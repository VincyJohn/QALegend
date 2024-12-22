package Pageclasses;

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
@FindBy (xpath = "//button[@id='otvhqlvnyxfvmrw']")
WebElement uploadfilebtn;
@FindBy(xpath = "//div[@id='s2id_note_labels']")
WebElement notelabel;
@FindBy (xpath="//div[@id='note-table_filter']//descendant::input")
WebElement searchbox;
@FindBy (xpath = "//a[@title='Note']")
WebElement note;

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

public void addNote(String Title,String Description)
{
	pageutilities.enterText(notetitle, Title);
	notedescription.sendKeys(Description);
	pageutilities.clickOnElement(savebutton);
	
}

public void searchNoteAdded(String notename)
{
    WaitUtility.waitForClickingElement(driver, searchbox);
	pageutilities.clickOnElement(searchbox);
	pageutilities.enterText(searchbox, notename);
	
}

public String getNoteAdded()
{
String note1=pageutilities.readText(note);
return note1;

}
}
