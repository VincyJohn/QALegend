package TestScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendMessageTest extends BaseClass
{
	@Test 
public void verifyComposeMessage() throws IOException, InterruptedException
{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageMessageButton();
		String Tomailid =ExcelUtility.getStringData(1, 0, "Message");
		String subject=ExcelUtility.getStringData(1, 1, "Message")+FakerUtility.randomNumberGenerator();
		String message=ExcelUtility.getStringData(1, 2, "Message");
		messagepage.addMessage(Tomailid, subject, message);
		messagepage.getMessageOnSentItems(subject);
	    String msg=messagepage.getMessageAdded();
	    Assert.assertEquals(msg, message);
}
}
