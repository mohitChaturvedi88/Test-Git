/**
 * 
 */
package Basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import POM.FactoryObjectLoginPage;
import utils.UseBrowser;

/**
 * @author India
 *
 */
public class VerifyLoginWithFactoryObject {

	

	@Test
	public void VerifyValidLogin() throws Exception{
		
		// This will launch browser and specific url
		WebDriver driver=UseBrowser.startBrowser("Chrome","http://54.69.31.248/index.php/login/RegisterVendor");
		
		//Take ScreenShots
		utils.CaptureScreenShot.TakeScreenShot(driver,"Screenshot1");
		
		//Created "FactoryObjectLoginPage" Object using Page Factory 
		FactoryObjectLoginPage FactoryObject = PageFactory.initElements(driver, FactoryObjectLoginPage.class);

		
		
		//Call the method
		FactoryObject.Basket_login("Mohitchaturvedi88@gmail.com", "testpassword");
		
	}
}
