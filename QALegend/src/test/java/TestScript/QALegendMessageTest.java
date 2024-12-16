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
		String subject=ExcelUtility.getStringData(1, 1, "Message");
		String messagearea=ExcelUtility.getStringData(1, 2, "Message");
		messagepage.addMessage(Tomailid, subject, messagearea);
		messagepage.getMessageOnSentItems(subject);
	/*	String notetext=messagepage.getMessageAdded(subject);
		Boolean value=Boolean.valueOf(PageUtilities.compareTwoStrings(notetitlenew,notetext));
		Assert.assertEquals(value, true); */
}
}
