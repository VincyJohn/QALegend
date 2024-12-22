package Pageclasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendProjectPage 
{
	public WebDriver driver;
	public PageUtilities pageutilities;
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
	//@FindBy (xpath="//div[@id='project-table_filter']//descendant::input")
	@FindBy(xpath="//input[@type='search']")
	WebElement srchbox;
	@FindBy (xpath ="//a[@title='Delete project']")
	WebElement deleteprojectbutton;
	@FindBy (xpath="//button[text()='Status ']")
	WebElement statusdrpdwnfield;
   @FindBy (xpath ="//li[text()='Open']" )
   WebElement opendrpdwnvalue;
   @FindBy (xpath ="//li[text()='Completed']" )
   WebElement completeddrpdwnvalue;
   @FindBy (id="ajaxModalContent")
   WebElement addprojectmodal;
   @FindBy (id="confirmDeleteButton")
   WebElement confirmdeletebtn;
   @FindBy (xpath ="//div[text()='The record has been deleted.']" )
   WebElement deletenotification;
   @FindBy(xpath = "//td[text()='No record found.']")
   WebElement nodatamsg;
   @FindBy (xpath = "(//td[text()='Completed'])[1]")
   WebElement completedstatus;
  
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
		WaitUtility.waitForClickingElement(driver, deadlinedatebox);
		pageutilities.clickOnElement(deadlinedatebox);
		pageutilities.clickOnElement(deadlinedateselectbtn);
		pageutilities.clickOnElement(savebtn);
	}
	public void searchProjectAdded(String title) throws InterruptedException
	{
		WaitUtility.waitForInVisiblityOfElement(driver, addprojectmodal);
		pageutilities.javaScriptClick(srchbox);
		pageutilities.enterText(srchbox, title);
	}
	public void deleteProject()
	{		
		pageutilities.clickOnElement(deleteprojectbutton);
		pageutilities.clickOnElement(confirmdeletebtn);
		pageutilities.isElementDispalyed(deletenotification);
		
	}
	public void checkForDeletedProject()
	{
		pageutilities.javaScriptClick(srchbox);
		pageutilities.isElementDispalyed(nodatamsg);
		
	}
	
	public void searchCompletedProject()
	{
		pageutilities.clickOnElement(statusdrpdwnfield);
		pageutilities.clickOnElement(opendrpdwnvalue);
		pageutilities.pageDownKeyPress();
		pageutilities.clickOnElement(completeddrpdwnvalue);
		WaitUtility.waitForVisiblityOfElement(driver, completedstatus);
	}
	
	public void verifyStatusForCompletedProjects()
	{
		List<WebElement> status=driver.findElements(By.xpath("//td[text()='Completed']"));
		int s=status.size();
		String statusval="Completed";
		System.out.println(s);
		Iterator<WebElement> lst= status.iterator();
		while (lst.hasNext())
		{
			String projectstatus =lst.next().getText();
			if(statusval.equals(projectstatus))
			{
				System.out.println("All projects displayed have completed status");
			}
			else
			{
				System.out.println("Projects displayed are not in completed status");
			}
		}
	}
	
	
}
