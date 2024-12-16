package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomepage {
	public WebDriver driver;
	public PageUtilities pageutilities;
	
	@FindBy (xpath = "//span[text()='Events']")
	WebElement homepageeventbutton;
	@FindBy (xpath = "//span[text()='Lekshmi Nair']")
	WebElement userprofilename;
	@FindBy (xpath = "//span[text()='Notes']")
	WebElement homepagenotebutton;
	@FindBy (xpath = "//span[text()='Messages']")
	WebElement homepagemessagebutton;
	@FindBy (xpath="//span[text()='Clients']")
	WebElement homepageclientbutton;
	@FindBy (xpath ="//span[text()='Projects']" )
	WebElement homepageprojectbutton;
	@FindBy (xpath = "//span[text()='All Projects']")
	WebElement Allprojectsbutton;
	@FindBy (xpath = "//span[text()='Tickets']")
	WebElement homepageticketbutton;
	
	public QALegendHomepage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public Boolean profileNameCheck()
	{
		return (pageutilities.isElementDispalyed(userprofilename));
		
	}

	public void clickOnHomepageEventButton()
	{
		homepageeventbutton.click();
	}
	
	
	
	public void clickOnHomePageNoteButton()
	{
		homepagenotebutton.click();
	}
	public void clickOnHomePageMessageButton()
	{
		homepagemessagebutton.click();
	}
	public void clickOnHomePageClientButton()
	{
		homepageclientbutton.click();
	}
	public void clickOnHomePageProjectButton()
	{
		homepageprojectbutton.click();
	}
	public void clickOnHomePageAllProjectsButton()
	{
		Allprojectsbutton.click();
	}
	public void clickOnHomePageTicketButton()
	{
		homepageticketbutton.click();
	}
}
