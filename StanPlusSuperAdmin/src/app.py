from flask import Flask, request, jsonify
import os
import openai
import requests
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)

openai.api_key = os.getenv("OPENAI_API_KEY")
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN")
GITHUB_REPO = os.getenv("GITHUB_REPO")  # Format: username/repo

# Headers for GitHub API
github_headers = {
    "Authorization": f"token {GITHUB_TOKEN}",
    "Accept": "application/vnd.github.v3+json"
}

@app.route("/github-webhook", methods=["POST"])
def github_webhook():
    print("🔔 Webhook triggered")

    payload = request.json
    if not payload:
        print("❌ No JSON payload received")
        return jsonify({"error": "No payload"}), 400

    event = request.headers.get("X-GitHub-Event")
    print(f"📨 GitHub Event: {event}")

    if event != "pull_request":
        print("❌ Not a pull_request event")
        return jsonify({"message": "Ignored event"}), 200

    action = payload.get("action")
    print(f"➡️ PR Action: {action}")

    if action not in ["opened", "synchronize"]:
        print(f"ℹ️ Skipping PR action: {action}")
        return jsonify({"message": f"Ignored action {action}"}), 200

    try:
        pr = payload["pull_request"]
        pr_number = pr["number"]
        pr_title = pr["title"]
        pr_url = pr["url"]
        diff_url = pr["diff_url"]
        sender = payload.get("sender", {}).get("login", "unknown")
    except KeyError as e:
        print(f"❌ Error parsing PR payload: {e}")
        return jsonify({"error": f"Malformed PR payload: {str(e)}"}), 400

    print(f"📦 PR #{pr_number} - '{pr_title}' by {sender}")
    print(f"🔗 PR API URL: {pr_url}")
    print(f"📄 Diff URL: {diff_url}")

    # Get PR diff
    print("📥 Fetching PR diff...")
    diff_resp = requests.get(diff_url, headers=github_headers)
    if diff_resp.status_code != 200:
        print(f"❌ Failed to fetch PR diff: {diff_resp.status_code} {diff_resp.text}")
        return jsonify({"error": "Failed to fetch PR diff"}), 500

    diff_text = diff_resp.text
    print(f"✅ Diff fetched ({len(diff_text)} characters)")

    prompt = f"""You are a code reviewer bot. Review the following diff and suggest improvements.
If the code is good, say "LGTM" (Looks Good To Me). Otherwise, give clear feedback.

Here is the diff:
{diff_text}
"""

    try:
        print("🤖 Sending diff to OpenAI for review...")
        response = openai.ChatCompletion.create(
            model="gpt-4",
            messages=[
                {"role": "user", "content": prompt}
            ],
            max_tokens=500
        )
        review = response['choices'][0]['message']['content']
        print("✅ AI review received.")
        print(f"📝 AI Review:\n{review}")
    except Exception as e:
        print(f"❌ OpenAI API error: {e}")
        return jsonify({"error": str(e)}), 500

    # Post comment to PR
    comment_url = f"https://api.github.com/repos/{GITHUB_REPO}/issues/{pr_number}/comments"
    print("🗨️ Posting AI review as PR comment...")
    comment_resp = requests.post(comment_url, json={"body": review}, headers=github_headers)

    if comment_resp.status_code != 201:
        print(f"❌ Failed to post comment: {comment_resp.status_code} {comment_resp.text}")
        return jsonify({"error": "Failed to post comment"}), 500

    print("✅ Review comment posted successfully.")

    # Auto-merge if AI says LGTM
    if "LGTM" in review or "Looks good to me" in review:
        print("🤝 AI approved the PR. Attempting auto-merge...")
        merge_url = f"https://api.github.com/repos/{GITHUB_REPO}/pulls/{pr_number}/merge"
        merge_resp = requests.put(merge_url, headers=github_headers, json={
            "commit_title": "Auto-merged by AI reviewer",
            "merge_method": "merge"
        })

        if merge_resp.status_code == 200:
            print("✅ PR successfully auto-merged.")
            return jsonify({"message": "PR auto-merged"}), 200
        else:
            print(f"❌ Auto-merge failed: {merge_resp.status_code} {merge_resp.text}")
            return jsonify({"error": "Failed to auto-merge"}), 500

    print("✅ Review complete. No auto-merge.")
    return jsonify({"message": "PR reviewed and commented"}), 200

if __name__ == "__main__":
    print("🚀 Starting Flask server on port 5000")
    app.run(port=5000)
