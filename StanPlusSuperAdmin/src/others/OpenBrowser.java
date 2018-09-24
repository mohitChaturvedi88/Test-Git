package others;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
	
	
public class OpenBrowser {

	
	@Test 
	public void OpenFirefox() throws InterruptedException{
	
		System.setProperty("webdriver.gecko.driver", "D:\\Automation\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.toolsqa.com");

		Thread.sleep(5000);
		//driver.quit();
	}

}
	

