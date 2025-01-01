package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendTicketTest extends BaseClass
{
	@Test (retryAnalyzer=TestScript.RetryAnalyser.class)
	public void verifyTicketAssignment() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageTicketButton();
		String loggeduser=homepage.findLoggeduser();
		ticketpage.clickOnAddTicketButton();
		String tickettitle =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Ticket")+FakerUtility.randomNumberGenerator();
		String ticketdescription=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Ticket");
		String clientname=ExcelUtility.getNumericData(1, 2,ConstantsValues.TESTDATAFILE,"Ticket");
		ticketpage.addTicket(tickettitle, ticketdescription,clientname);
		ticketpage.searchTicketAdded(tickettitle);
		String assigneduser=ticketpage.assignTicketToLoggedUser();
		Assert.assertEquals(assigneduser,loggeduser);
	}
	@Test(retryAnalyzer=TestScript.RetryAnalyser.class)
	public void verifyTicketMarkedAsClosed() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageTicketButton();
		ticketpage.clickOnAddTicketButton();
		String tickettitle =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Ticket")+FakerUtility.randomNumberGenerator();
		String ticketdescription=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Ticket");
		String clientname=ExcelUtility.getNumericData(1, 2,ConstantsValues.TESTDATAFILE,"Ticket");
		ticketpage.addTicket(tickettitle, ticketdescription,clientname);
		ticketpage.searchTicketAdded(tickettitle);
		String Status=ticketpage.markTicketToClosed();
		Assert.assertEquals(Status,"Closed");
	}
}
