package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendNoteTest extends BaseClass
{
	@Test
	public void addNoteTest() throws IOException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageNoteButton();
		notepage.clickOnAddNotebutton();
		String notetitlenew =ExcelUtility.getStringData(1, 0, "Note")+FakerUtility.randomNumberGenerator();
		String notedescription=ExcelUtility.getStringData(1, 1, "Note");
		notepage.addNote(notetitlenew, notedescription);
		String notetext=notepage.getNoteAdded(notetitlenew);
		Boolean value=Boolean.valueOf(PageUtilities.compareTwoStrings(notetitlenew,notetext));
		Assert.assertEquals(value, true);
	}

}
