package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendProjectPage 
{
	public WebDriver driver;
	public PageUtilities pageutilities;
	public WaitUtility waitutility;
	@FindBy (xpath="//a[@title='Add project']")
	WebElement addprojectbutton;
	@FindBy(id="title")
	WebElement projecttitlebox;
	@FindBy(id="description")
	WebElement projectdescriptionbox;
	@FindBy (xpath = "//input[@id='deadline']")
	WebElement deadlinedatebox;
	@FindBy (xpath="//td[@class='today day']")
	WebElement deadlinedateselectbtn;
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	WebElement savebtn;
	@FindBy (xpath = "//input[@type='search']")
	WebElement srchbox;
	@FindBy (xpath ="//a[@title='Delete project']")
	WebElement deleteprojectbutton;
	@FindBy (xpath="//button[text()='Status ']")
	WebElement statusdrpdwnfield;
   @FindBy (xpath ="//li[text()='Open']" )
   WebElement opendrpdwnvalue;
   @FindBy (xpath ="//li[text()='Completed']" )
   WebElement completeddrpdwnvalue;
	public QALegendProjectPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	public void clickOnAddProjectButton() 
	{
		
		pageutilities.clickOnElement(addprojectbutton);
	}
	public void addProject(String title,String description)
	{
		pageutilities.enterText(projecttitlebox, title);
		pageutilities.enterText(projectdescriptionbox, description);
		pageutilities.javascriptScrollElementToView(deadlinedatebox);
		pageutilities.clickOnElement(deadlinedatebox);
		pageutilities.clickOnElement(deadlinedateselectbtn);
		pageutilities.clickOnElement(savebtn);
	}
	public void deleteProject(String title)
	{
		waitutility.waitForClickingElement(driver, srchbox);
		pageutilities.clickOnElement(srchbox);
		pageutilities.enterText(srchbox, title);
		pageutilities.clickOnElement(deleteprojectbutton);
	}
	public void searchCompletedProject()
	{
		pageutilities.clickOnElement(statusdrpdwnfield);
		pageutilities.clickOnElement(opendrpdwnvalue);
		pageutilities.pageDownKeyPress();
		pageutilities.clickOnElement(completeddrpdwnvalue);
	}
	
}
