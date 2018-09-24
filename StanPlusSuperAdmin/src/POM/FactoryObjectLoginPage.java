/**
 * 
 */
package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author India
 *
 */
public class FactoryObjectLoginPage {

		WebDriver driver;

	// Create constructor of the class
		public FactoryObjectLoginPage(WebDriver driver) {
			this.driver = driver;
			}
	
	
	/**
	 * Elements locating using "Factory" Class.
	 * Important feature of Page Factory is Cache feature that will store all frequently used Web Elements in cache.
	 * We have Separate method for initializing web elements.
	 */
	
//Normal way to use FindBy.	
	@FindBy(linkText = "Login") 
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement login_link_text;
	
	@FindBy(linkText= "Sign Up")
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement signUp_link_text;
	
//Standard way to use FindBy using HOW.
	//How is a class here.s
	@FindBy(how = How.ID, using="txt_name") 
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement email_address;
	
	@FindBy(how = How.ID, using="password") 
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement Password;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div[1]/div[2]/div[3]/form/fieldset[3]/input")
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement CheckBox;
	
	@FindBy(how = How.CLASS_NAME, using="posabslte")
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement view_password;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div[1]/div[2]/div[3]/form/div")
	@CacheLookup			//Here "@CacheLookup" will check the element in the Cache and will pick from Cache so Performance will high.
	WebElement Login_button;

	
	// write methods for individual elements.	
		public void Click_on_login_link_text(){
			
		login_link_text.click();
			}
		
		public void Click_on_signUp_link_text(){
			
		signUp_link_text.click();
			}
		
		public void Type_emailAddress(String email){
			
		email_address.sendKeys(email);
			}
		
		public void Type_password(String pass){
			
		Password.sendKeys(pass);
			}
		
		public void Click_on_Check_Box(){
			
		CheckBox.click();
			}
		
		public void Click_on_view_password(){
			
		view_password.click();
			}
		public void Click_on_Login_button(){
			
		Login_button.click();
			}

		
		//Write a common method for SignUp.
		
		public void Basket_login(String email, String pass){
			login_link_text.click();
			email_address.sendKeys(email);
			Password.sendKeys(pass);
			CheckBox.click();
			view_password.click();
			Login_button.click();
			driver.quit();
		}
	}

