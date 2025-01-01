package TestScript;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.ConstantsValues;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendProjectTest extends BaseClass
{	
	@Test(retryAnalyzer=TestScript.RetryAnalyser.class,groups= {"Smoke"})
	public void verifyAddProject() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.clickOnAddProjectButton();
		String prjtitle =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Project")+FakerUtility.randomNumberGenerator();
		String prjdescription=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Project");
		projectpage.addProject(prjtitle, prjdescription);
		String project=projectpage.searchProjectAdded(prjtitle);
		Assert.assertEquals(project,prjtitle );
	}
	@Test(retryAnalyzer=TestScript.RetryAnalyser.class,groups= {"Regression"})
	public void verifyDeleteProject() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.clickOnAddProjectButton();
		String prjtitle =ExcelUtility.getStringData(1, 0,ConstantsValues.TESTDATAFILE,"Project")+FakerUtility.randomNumberGenerator();
		String prjdescription=ExcelUtility.getStringData(1, 1,ConstantsValues.TESTDATAFILE,"Project");
		projectpage.addProject(prjtitle, prjdescription);
		projectpage.searchProjectAdded(prjtitle);
		projectpage.deleteProject();
		Boolean MsgNodatafound=projectpage.checkForDeletedProject();
		Assert.assertEquals(MsgNodatafound, true);
		
	}
	@Test (retryAnalyzer=TestScript.RetryAnalyser.class)
	public void verifySearchForCompletedProjects()
	{	
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.searchCompletedProject();
		Boolean status=projectpage.verifyStatusForCompletedProjects();
		Assert.assertEquals(status, true);
	}		
}
