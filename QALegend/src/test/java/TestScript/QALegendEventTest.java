package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendEventTest extends BaseClass
{
	@Test
public void verifyAddEvent() throws IOException
{
	loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnHomepageEventButton();
	eventpage.clickOnAddEventButton();
	String eventtitle =ExcelUtility.getStringData(1, 0, "Event")+FakerUtility.randomNumberGenerator();
	String eventdescription=ExcelUtility.getStringData(1, 1, "Event");
	eventpage.addEvent(eventtitle, eventdescription);
	Assert.assertEquals(eventpage.eventPageSaveButtonStatusChecker(), true);
}
}

