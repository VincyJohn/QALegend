package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;

public class QALegendLoginTest extends BaseClass
{
	@Test
	public void validLoginCheck()
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(homepage.profileNameCheck(), true);
		System.out.println("User is valid");
	}
	@Test
	public void invalidLoginCheck() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Login");
		String password=ExcelUtility.getNumericData(1, 1,ConstantsValues.TESTDATAFILE,"Login");
		loginpage.login(username, password);
		Assert.assertEquals(loginpage.invalidLoginValidation(), true);
		System.out.println("User is invalid");
	}
	

}

