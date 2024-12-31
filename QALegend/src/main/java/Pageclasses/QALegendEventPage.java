package Pageclasses;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendEventPage 
{

	public QALegendEventPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public WebDriver driver;
	public PageUtilities pageutilities;
	@FindBy (xpath="(//a[@title='Add event'])[2]")
	WebElement addeventbutton;
	@FindBy (xpath ="//input[@id='title']" )
	WebElement titlebox;
	@FindBy (id="description")
	WebElement descriptionbox;
	@FindBy (id="start_date")
	WebElement Startdate;
	@FindBy (id="start_time")
	WebElement starttime;
	@FindBy (id="end_date")
	WebElement Enddate;
	@FindBy (id="end_time")
	WebElement endtime;
	@FindBy (id="location")
	WebElement locationbox;
	@FindBy (id="s2id_event_labels")
	WebElement labelsbox;
	@FindBy (id="select2-chosen-9")
	WebElement client;
	@FindBy (id="only_me")
	WebElement onlymeradiobutton;
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	WebElement savebtn;
	
	public void clickOnAddEventButton() 
	{
		pageutilities.clickOnElement(addeventbutton);
	}
	public void addEvent(String title,String description,String startdate,String enddate)
	{
		titlebox.sendKeys(title);
		pageutilities.enterText(descriptionbox, description);
		pageutilities.enterText(Startdate, startdate);
		pageutilities.enterText(Enddate, enddate);
		//2024-12-30
		
	}
	
	public Boolean eventPageSaveButtonStatusChecker()
	{
		return (pageutilities.isElementEnabled(savebtn));
	}
}
