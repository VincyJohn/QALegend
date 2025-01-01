package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendClientTest extends BaseClass
{
	@Test(retryAnalyzer=TestScript.RetryAnalyser.class,groups= {"Smoke"})
	public void verifyAddClient() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageClientButton();
		clientpage.clickOnAddClientButton();
		String company =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE, "Client")+FakerUtility.randomNumberGenerator();
		String addr=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE, "Client");
		String city=ExcelUtility.getStringData(1, 2,ConstantsValues.TESTDATAFILE, "Client");
		String state=ExcelUtility.getStringData(1, 3,ConstantsValues.TESTDATAFILE, "Client");
		String country=ExcelUtility.getStringData(1, 4,ConstantsValues.TESTDATAFILE, "Client");
		String phone=ExcelUtility.getNumericData(1, 5,ConstantsValues.TESTDATAFILE, "Client");
		String currency=ExcelUtility.getStringData(1, 6,ConstantsValues.TESTDATAFILE, "Client");
		clientpage.addClient(company, addr, city, state, country, phone, currency);
		String client=clientpage.searchForAddedClient(company);
		Assert.assertEquals(client,company );
	
	}
	@Test(retryAnalyzer=TestScript.RetryAnalyser.class,groups= {"Regression"}) 
	public void verifyEditClient() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageClientButton();
		clientpage.clickOnAddClientButton();
		String company =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Client")+FakerUtility.randomNumberGenerator();
		String addr=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Client");
		String city=ExcelUtility.getStringData(1, 2,ConstantsValues.TESTDATAFILE,"Client");
		String state=ExcelUtility.getStringData(1, 3,ConstantsValues.TESTDATAFILE,"Client");
		String country=ExcelUtility.getStringData(1, 4,ConstantsValues.TESTDATAFILE,"Client");
		String phone=ExcelUtility.getNumericData(1, 5,ConstantsValues.TESTDATAFILE,"Client");
		String currency=ExcelUtility.getStringData(1, 6,ConstantsValues.TESTDATAFILE,"Client");
		clientpage.addClient(company, addr, city, state, country, phone, currency);
		clientpage.searchForAddedClient(company);
		String addrnew=ExcelUtility.getStringData(1,7,ConstantsValues.TESTDATAFILE,"Client")+FakerUtility.randomNumberGenerator();
		String actualaddr=clientpage.editNoteAdded(addrnew);
		Assert.assertEquals(actualaddr,addrnew );
	
	}

}
