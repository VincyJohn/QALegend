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
   @FindBy(xpath = "//td[text()='Completed']")
   List<WebElement> status;
   @FindBy (xpath = "(//td[@class=' w50']//following::a)[1]")
   WebElement prjadded;
  
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
	public QALegendProjectPage addProject(String title,String description)
	{
		pageutilities.enterText(projecttitlebox, title);
		pageutilities.enterText(projectdescriptionbox, description);
		WaitUtility.waitForClickingElement(driver, deadlinedatebox);
		pageutilities.clickOnElement(deadlinedatebox);
		pageutilities.clickOnElement(deadlinedateselectbtn);
		pageutilities.clickOnElement(savebtn);
		return this;
	}
	public String searchProjectAdded(String title) throws InterruptedException
	{
		WaitUtility.waitForInVisiblityOfElement(driver, addprojectmodal);
		pageutilities.javaScriptClick(srchbox);
		pageutilities.enterText(srchbox, title);
		String prjname=pageutilities.readText(prjadded);
		return prjname;
	}
	public QALegendProjectPage deleteProject()
	{		
		pageutilities.clickOnElement(deleteprojectbutton);
		pageutilities.clickOnElement(confirmdeletebtn);
		pageutilities.isElementDispalyed(deletenotification);
		return this;
	}
	public Boolean checkForDeletedProject()
	{
		pageutilities.javaScriptClick(srchbox);
		Boolean msgfound=pageutilities.isElementDispalyed(nodatamsg);
		return msgfound;
		
	}
	
	public void searchCompletedProject()
	{
		pageutilities.clickOnElement(statusdrpdwnfield);
		pageutilities.clickOnElement(opendrpdwnvalue);
		pageutilities.pageDownKeyPress();
		pageutilities.clickOnElement(completeddrpdwnvalue);
		WaitUtility.waitForVisiblityOfElement(driver, completedstatus);
	}
	
	public Boolean verifyStatusForCompletedProjects()
	{
		int s=status.size();
		Boolean status1 = null;
		String statusval="Completed";
		System.out.println(s);
		Iterator<WebElement> lst= status.iterator();
		while (lst.hasNext())
		{
			String projectstatus =lst.next().getText();
			if(statusval.equals(projectstatus))
			{
				status1=true;
			}
			else
			{
				status1=false;
			}
			
		}
		return status1;
	}
	
}
