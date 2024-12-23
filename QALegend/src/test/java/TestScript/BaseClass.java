package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Constants.ConstantsValues;
import Pageclasses.QALegendClientPage;
import Pageclasses.QALegendEventPage;
import Pageclasses.QALegendHomepage;
import Pageclasses.QALegendLoginPage;
import Pageclasses.QALegendMessagePage;
import Pageclasses.QALegendNotePage;
import Pageclasses.QALegendProjectPage;
import Pageclasses.QALegendTicketPage;
import Utilities.ScreenshotUtility;

public class BaseClass 
{
public WebDriver driver;
QALegendLoginPage loginpage;
QALegendHomepage homepage;
QALegendEventPage eventpage;
QALegendNotePage notepage;
QALegendMessagePage messagepage;
QALegendClientPage clientpage;
QALegendProjectPage projectpage;
QALegendTicketPage ticketpage;
public Properties prop;
public FileInputStream fis;
@BeforeMethod(alwaysRun = true)	
@Parameters("browser")
	public void browserinitialization(String browsername) throws Exception
	{
		if (browsername.equalsIgnoreCase("Chrome"))
		{
			
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if (browsername.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		
		else
		{
			throw new Exception("Invalid name exception");
		}
		prop=new Properties();
		fis= new FileInputStream(ConstantsValues.USERDATAFILE);
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginpage= new QALegendLoginPage(driver);
		homepage= new QALegendHomepage(driver);
		eventpage= new QALegendEventPage(driver);
		notepage=new QALegendNotePage(driver);
		messagepage=new QALegendMessagePage(driver);
		clientpage=new QALegendClientPage(driver);
		projectpage=new QALegendProjectPage(driver);
		ticketpage=new QALegendTicketPage(driver);
		
}
@AfterMethod
public void afterMethod(ITestResult itResult) throws IOException {
	if(itResult.getStatus()==ITestResult.FAILURE) {
		ScreenshotUtility sc = new ScreenshotUtility();
		sc.captureFailureScreenshot(driver, itResult.getName());
	}
	if(driver!=null) {
		driver.quit();
	}
}



}
