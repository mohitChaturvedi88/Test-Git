package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenShot {
	
	public static void TakeScreenShot(WebDriver driver,String ScreenshotName ) throws Exception{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = (File) ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\ScreenShots\\"+ScreenshotName+".png"));
	}

}
