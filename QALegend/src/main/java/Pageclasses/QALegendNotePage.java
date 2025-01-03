package Pageclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendNotePage 
{
	
public WebDriver driver;
public PageUtilities pageutilities;
@FindBy(xpath = "(//a[@title='Add note'])[2]")
WebElement addnotebutton;
@FindBy (id="title")
WebElement notetitle;
@FindBy (id="description")
WebElement notedescription;
@FindBy (xpath ="//button[@type='submit']")
WebElement savebutton;
@FindBy (xpath = "//button[contains(@class,'upload-file')]")
WebElement uploadfilebtn;
@FindBy(xpath = "//div[@id='s2id_note_labels']")
WebElement notelabel;
@FindBy (xpath="//div[@id='note-table_filter']//descendant::input")
WebElement searchbox;
@FindBy (xpath = "//a[@title='Note']")
WebElement note;
@FindBy(xpath = "//div[@id='ajaxModalContent']")
WebElement notemodal;

public QALegendNotePage(WebDriver driver)
{
	this.driver=driver;
	this.pageutilities=new PageUtilities(driver);
	PageFactory.initElements(driver, this);
}

public void clickOnAddNotebutton()
{
	pageutilities.clickOnElement(addnotebutton);
}

public QALegendNotePage addNote(String Title,String Description,String path) throws AWTException, InterruptedException
{
	pageutilities.enterText(notetitle, Title);
	notedescription.sendKeys(Description);
	pageutilities.clickOnElement(uploadfilebtn);
	fileUpload(path);
	pageutilities.clickOnElement(savebutton);
	return this;
}

public void searchNoteAdded(String notename)
{
	WaitUtility.waitForInVisiblityOfElement(driver, notemodal);
	pageutilities.clickOnElement(searchbox);
	pageutilities.enterText(searchbox, notename);
	
}

public String getNoteAdded()
{
String note1=pageutilities.readText(note);
return note1;

}

public void fileUpload(String path) throws AWTException, InterruptedException
{
	StringSelection stringselection=new StringSelection(path);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}

}
