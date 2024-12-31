package TestScript;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendProjectTest extends BaseClass
{	
	@Test
	public void verifyAddProject() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.clickOnAddProjectButton();
		String prjtitle =ExcelUtility.getStringData(1, 0, "Project")+FakerUtility.randomNumberGenerator();
		String prjdescription=ExcelUtility.getStringData(1, 1, "Project");
		projectpage.addProject(prjtitle, prjdescription);
		String project=projectpage.searchProjectAdded(prjtitle);
		Assert.assertEquals(project,prjtitle );
	}
	@Test
	public void verifyDeleteProject() throws IOException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.clickOnAddProjectButton();
		String prjtitle =ExcelUtility.getStringData(1, 0, "Project")+FakerUtility.randomNumberGenerator();
		String prjdescription=ExcelUtility.getStringData(1, 1, "Project");
		projectpage.addProject(prjtitle, prjdescription);
		projectpage.searchProjectAdded(prjtitle);
		projectpage.deleteProject();
		Boolean MsgNodatafound=projectpage.checkForDeletedProject();
		Assert.assertEquals(MsgNodatafound, true);
		
	}
	@Test 
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
