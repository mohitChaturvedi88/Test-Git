package Basket;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Url;


public class Login_SignUp_Page {

	WebDriver driver;
	String Login_Url;
	String CurrentURL;
	String Yourtext;
	String temp;
	
	@Test
	public void ReachPage(){
		System.setProperty("webdriver.chrome.driver", Url.Chrome_driver_path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url.Basket_Url);
		Assert.assertEquals("Basket",driver.getTitle());
	}
	
	@Test (dependsOnMethods = { "ReachPage" })
	public void Available_Text(){
		
		 Assert.assertEquals("BASKET",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/span[1]")).getText());
		 Assert.assertEquals("Online Grocery Shopping",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/span[2]")).getText());
		 Assert.assertEquals("Best Online Grocery Store",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[1]")).getText());
		 Assert.assertEquals("Best Products",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[2]")).getText());
		 Assert.assertEquals("Best Quality",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[3]")).getText());
		 Assert.assertEquals("Sign up",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/span")).getText());
		 Assert.assertEquals("Login",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/a")).getText());
		 Assert.assertEquals("First Name",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/fieldset[1]/label")).getText());
		 Assert.assertEquals("Last Name",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/fieldset[2]/label")).getText());
		 Assert.assertEquals("Email Address",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/fieldset[3]/label")).getText());
		 Assert.assertEquals("Password",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/fieldset[4]/label")).getText());
		 Assert.assertEquals("Next",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div")).getText());
		 
	}
	
	@Test (dependsOnMethods = { "Available_Text" })
	public void Login_Urls(){
		
		driver.findElement(By.linkText("Login")).click();
		Login_Url = driver.getCurrentUrl();
		 Assert.assertEquals("http://54.69.31.248/index.php/login/VendorLogin", Login_Url );
	}
	
	@Test (dependsOnMethods = { "Login_Urls" })
	public void Available_Text_login(){
		
		 Assert.assertEquals("BASKET",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/span[1]")).getText());
		 Assert.assertEquals("Online Grocery Shopping",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/span[2]")).getText());
		 Assert.assertEquals("Best Online Grocery Store",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[1]")).getText());
		 Assert.assertEquals("Best Products",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[2]")).getText());
		 Assert.assertEquals("Best Quality",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/ul/li[3]")).getText());
		 Assert.assertEquals("Sign Up",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/a")).getText());
		 Assert.assertEquals("Login",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/span")).getText());
		 Assert.assertEquals("Email Address",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/form/fieldset[1]/label")).getText());
		 Assert.assertEquals("Password",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/form/fieldset[2]/label")).getText());
		 Assert.assertEquals("keep me logged in",driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/form/fieldset[3]/span")).getText());
		 Assert.assertEquals("Login",driver.findElement(By.id("login_submit")).getText());
		 Assert.assertEquals("New to basket ? Sign Up / Forgot Password ?",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div")).getText());
		
	
	}
	
	@Test (dependsOnMethods = { "Available_Text_login" })
	public void SignUp_Url(){
		
		driver.findElement(By.linkText("Sign Up")).click();
		 Assert.assertEquals("http://54.69.31.248/index.php/login/RegisterVendor", driver.getCurrentUrl());
		
	}
	
	@Test (dependsOnMethods = { "SignUp_Url" })
	public void SignUp_Leave_All_Blank(){

		
		driver.findElement(By.id("registerVendor")).sendKeys(Keys.ENTER);
		temp = driver.findElement(By.className("alert-forget")).getText();
		
		//Assert.assertEquals("", driver.findElement(By.className("alert-forget")).getText());
		
		System.out.println(temp);
	
	}
}
