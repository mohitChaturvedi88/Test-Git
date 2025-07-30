/**
 * 
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * @author Mohit Chaturvedi
 *
 *This class will store all the locators and the methods of login page.
 *
 */
public class LoginPage {
	
	

	WebDriver driver;

	/**
	 * Elements locating using "By" Class.
	 */
	By login_link_text = By.linkText("Login");
	By signUp_link_text = By.linkText("Sign Up");
	By email_address = By.id("txt_name");
	By Password = By.id("password");
	By CheckBox = By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/form/fieldset[3]/input");
	By view_password = By.className("posabslte");
	By Login_button = By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/form/div");
	
	
	
	
	// Create constructor of the class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		}
			
	// write methods for individual elements.	
	public void Click_on_login_link_text(){
		
		driver.findElement(login_link_text).click();
		}
	
	public void Click_on_signUp_link_text(){
		
		driver.findElement(signUp_link_text).click();
		}
	
	public void Type_emailAddress(String email){
		
		driver.findElement(email_address).sendKeys(email);
		}
	
	public void Type_password(String pass){
		
		driver.findElement(Password).sendKeys(pass);
		}
	
	public void Click_on_Check_Box(){
		
		driver.findElement(CheckBox).click();
		}
	
	public void Click_on_view_password(){
		
		driver.findElement(view_password).click();
		}
	public void Click_on_Login_button(){
		
		driver.findElement(Login_button).click();
		}

	
	//Write a common method for SignUp.
	
	public void Basket_login(String email, String pass){
		driver.findElement(login_link_text).click();
		driver.findElement(email_address).sendKeys(email);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(CheckBox).click();
		driver.findElement(view_password).click();
		driver.findElement(Login_button).click();
		
	}
}
