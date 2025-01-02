
package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendEventTest extends BaseClass
{
	@Test(groups= {"Smoke"})
public void verifyAddEvent() throws IOException
{
	loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	homepage.clickOnHomepageEventButton();
	eventpage.clickOnAddEventButton();
	String eventtitle =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE, "Event")+FakerUtility.randomNumberGenerator();
	String eventdescription=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE, "Event");
	String eventstartdate=prop.getProperty("eventstartdate");
	String eventenddate=prop.getProperty("eventenddate");
	eventpage.addEvent(eventtitle, eventdescription,eventstartdate,eventenddate);
	Assert.assertEquals(eventpage.eventPageSaveButtonStatusChecker(), true);
}
}

