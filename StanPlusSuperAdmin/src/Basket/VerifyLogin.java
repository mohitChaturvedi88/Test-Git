/**
 * 
 */
package Basket;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import POM.LoginPage;
import utils.UseBrowser;

/**
 * @author Mohit Chaturvedi
 *
 */
public class VerifyLogin {

	WebDriver driver;
	
	@Test
	public void VerifyValidLogin() throws Exception{
		
		 driver=UseBrowser.startBrowser("Chrome","http://54.69.31.248/index.php/login/RegisterVendor");
		
		
		
		LoginPage login =new LoginPage(driver);
//login using each element method.
		/*login.Click_on_login_link_text();		
		login.Type_emailAddress("Mohitchaturvedi88@gmail.com");
		login.Type_password("testpassword");
		login.Click_on_view_password();
		login.Click_on_Check_Box();
		login.Click_on_Login_button();*/
		
		
		
//Login using a common method
		login.Basket_login("Mohitchaturvedi88@gmail.com", "testpassword");
		
		
	}
	
	// This method will take Screenshot of each failure Test using the name of the Test Case.
	@AfterMethod
	public void teardown(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus()){
			utils.CaptureScreenShot.TakeScreenShot(driver, result.getName());
		}
		driver.quit();
	}
	
}
