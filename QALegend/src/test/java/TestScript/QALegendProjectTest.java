package TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class QALegendProjectTest extends BaseClass
{
	@Test
	public void verifyAddProject() throws IOException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.clickOnAddProjectButton();
		String prjtitle =ExcelUtility.getStringData(1, 0, "Project")+FakerUtility.randomNumberGenerator();
		String prjdescription=ExcelUtility.getStringData(1, 1, "Project");
		projectpage.addProject(prjtitle, prjdescription);
		projectpage.deleteProject(prjtitle);
	}
	@Test
	public void VerifySearchForCompletedProjects()
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageProjectButton();
		homepage.clickOnHomePageAllProjectsButton();
		projectpage.searchCompletedProject();
	}
}
