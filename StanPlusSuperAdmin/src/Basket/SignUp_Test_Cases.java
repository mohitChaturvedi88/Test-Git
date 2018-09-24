package Basket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.UseBrowser;

public class SignUp_Test_Cases {
	
	WebDriver driver;
	String temp;
	
	@Test
	public void ReachPage() throws Exception{
	driver=UseBrowser.startBrowser("chrome","https://www.google.com/search?q=google&oq=google&aqs=chrome..69i57.4068j0j4&sourceid=chrome&ie=UTF-8");
	driver.findElement(By.id("Email")).sendKeys("Shivani");
	driver.findElement(By.id("Password")).sendKeys("Shivani");
	driver.findElement(By.className("row")).click();
	driver.get("http://34.210.104.96/Reports/ReportsList");
	driver.findElement(By.id("monthfunc")).click();
	
	
	driver.findElement(By.xpath("//*[@id='tr_click']/td[5]")).click();
	driver.findElement(By.className("btn btn-info")).click();
	
	
	driver.close();
		
	}
	
}
