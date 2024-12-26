package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendClientTest extends BaseClass
{
	@Test
	public void verifyAddClient() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageClientButton();
		clientpage.clickOnAddClientButton();
		String company =ExcelUtility.getStringData(1, 0, "Client")+FakerUtility.randomNumberGenerator();
		String addr=ExcelUtility.getStringData(1, 1, "Client");
		String city=ExcelUtility.getStringData(1, 2, "Client");
		String state=ExcelUtility.getStringData(1, 3, "Client");
		String country=ExcelUtility.getStringData(1, 4, "Client");
		String phone=ExcelUtility.getNumericData(1, 5, "Client");
		String currency=ExcelUtility.getStringData(1, 6, "Client");
		clientpage.addClient(company, addr, city, state, country, phone, currency);
		String client=clientpage.searchForAddedClient(company);
		Assert.assertEquals(client,company );
	
	}
	@Test
	public void verifyEditClient() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageClientButton();
		clientpage.clickOnAddClientButton();
		String company =ExcelUtility.getStringData(1, 0, "Client")+FakerUtility.randomNumberGenerator();
		String addr=ExcelUtility.getStringData(1, 1, "Client");
		String city=ExcelUtility.getStringData(1, 2, "Client");
		String state=ExcelUtility.getStringData(1, 3, "Client");
		String country=ExcelUtility.getStringData(1, 4, "Client");
		String phone=ExcelUtility.getNumericData(1, 5, "Client");
		String currency=ExcelUtility.getStringData(1, 6, "Client");
		clientpage.addClient(company, addr, city, state, country, phone, currency);
		clientpage.searchForAddedClient(company);
		clientpage.editNoteAdded();
	
	}

}
