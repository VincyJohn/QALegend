package TestScript;

import java.io.IOException;

import org.testng.Assert;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendTicketTest extends BaseClass
{
	public void verifyAddEvent() throws IOException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageTicketButton();
		ticketpage.clickOnAddTicketButton();
	}
}
