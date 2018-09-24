/**
 * 
 */
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Mohit Chaturvedi
 *
 */
public class UseBrowser {

	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			
			System.setProperty("webdriver.gecko.driver",Url.Firefox_driver_path);
			driver=new FirefoxDriver();
			
			
		}else if(browserName.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver",Url.Chrome_driver_path);
			driver=new ChromeDriver();
		
		}else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", Url.IE_driver_path);
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
}
