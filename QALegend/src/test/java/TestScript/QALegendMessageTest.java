package TestScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendMessageTest extends BaseClass
{
	@Test (retryAnalyzer=TestScript.RetryAnalyser.class,groups= {"Regression"})
public void verifyComposeMessage() throws IOException, InterruptedException
{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageMessageButton();
		String Tomailid =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Message");
		String subject=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Message")+FakerUtility.randomNumberGenerator();
		String message=ExcelUtility.getStringData(1, 2,ConstantsValues.TESTDATAFILE,"Message");
		messagepage.addMessage(Tomailid, subject, message);
		messagepage.getMessageOnSentItems(subject);
	    String msg=messagepage.getMessageAdded();
	    Assert.assertEquals(msg, message);
}
}
