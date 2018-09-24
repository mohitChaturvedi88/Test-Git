/**
 * 
 */
package DDT;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.LoginPage;
import utils.ExcelDataConfig;
import utils.UseBrowser;

/**
 * @author India
 *
 */
public class SimpleTestWithMultipleDataByExcel {
	
	WebDriver driver;
	
	@Test (dataProvider = "BasketLoginData")
	public void VerifyValidLogin(String username, String pass) throws InterruptedException{
		
		driver=UseBrowser.startBrowser("Chrome","http://54.69.31.248/index.php/login/RegisterVendor");
			LoginPage login =new LoginPage(driver);
				login.Click_on_login_link_text();		
				login.Type_emailAddress(username);
				login.Type_password(pass);
				login.Click_on_view_password();
				login.Click_on_Check_Box();
				login.Click_on_Login_button();
				
				System.out.println("Username : "+ username);
				System.out.println("Username : "+ pass);
				driver.quit();
		}

	
	@DataProvider (name="BasketLoginData")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig("C:\\Users\\Mohit\\eclipse-workspace\\ExcelData\\TestData.xlsx");
		int rows = config.getRowCount(0);
		
		
		Object [][] data = new Object[rows][2];
		
		for (int i = 0; i < rows; i++) {
			
			data [i][0]= config.getData(0, i, 0);
			data [i][1]= config.getData(0, i, 1);
			
		}
		
		return data;
		
	}
}
