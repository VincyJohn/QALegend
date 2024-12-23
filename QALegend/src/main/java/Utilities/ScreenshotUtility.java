package Utilities;

import java.io.IOException;
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility 
{
	public void captureFailureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		File screenshot = scrnshot.getScreenshotAs(OutputType.FILE);
		File f1 = new File(System.getProperty("user.dir")+"\\outputScreenShots");
		if(!f1.exists()) {
			f1.mkdirs();
		}
		File finalDestination = new File(System.getProperty("user.dir")+"\\outputScreenShots\\"+name+".png");
		FileHandler.copy(screenshot, finalDestination);
	}


}
