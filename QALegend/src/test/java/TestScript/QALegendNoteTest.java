package TestScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtilities;

public class QALegendNoteTest extends BaseClass
{
	@Test
	public void verifyAddNoteTest() throws IOException, AWTException, InterruptedException
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnHomePageNoteButton();
		notepage.clickOnAddNotebutton();
		String notetitlenew =ExcelUtility.getStringData(1, 0, "Note")+FakerUtility.randomNumberGenerator();
		String notedescription=ExcelUtility.getStringData(1, 1, "Note");
		String path=System.getProperty("user.dir")+prop.getProperty("uploadfilepath");
		System.out.println(path);
		notepage.addNote(notetitlenew, notedescription,path);
		notepage.searchNoteAdded(notetitlenew);
		String notetext=notepage.getNoteAdded();
		Assert.assertEquals(notetext, notetitlenew);
	}
}
