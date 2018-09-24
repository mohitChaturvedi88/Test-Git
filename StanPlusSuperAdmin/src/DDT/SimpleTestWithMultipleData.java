/**
 * 
 */
package DDT;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LoginPage;
import utils.UseBrowser;

/**
 * @author India
 *
 */
public class SimpleTestWithMultipleData {
	
	WebDriver driver;
	
	@Test (dataProvider = "BasketLoginData")
	public void VerifyValidLogin(String username, String password) throws Exception{
		
		driver=UseBrowser.startBrowser("Chrome","http://54.69.31.248/index.php/login/RegisterVendor");
			LoginPage login =new LoginPage(driver);
				login.Click_on_login_link_text();		
				login.Type_emailAddress(username);
				login.Type_password(password);
				login.Click_on_view_password();
				login.Click_on_Check_Box();
				login.Click_on_Login_button();
				Thread.sleep(3000);
				System.out.println("Username : "+ username);
				System.out.println("Username : "+ password);
				driver.quit();
		}

	
	@DataProvider (name="BasketLoginData")
	public Object [][] passData(){
		
		Object [][] data = new Object[3][2];
		
		data [0][0]= "Test1 Username";
		data [0][1]= "Test1 Password";
		
		data [1][0]= "Test2 Username";
		data [1][1]= "Test2 Password";
		
		data [2][0]= "Test3 Username";
		data [2][1]= "Test3 Password";
		
		
		return data;
		
	}
}
