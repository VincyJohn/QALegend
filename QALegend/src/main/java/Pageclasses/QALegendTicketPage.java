package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendTicketPage 
{

	public WebDriver driver;
	public PageUtilities pageutilities;
    @FindBy (xpath = "//a[@title='Add ticket']")
    WebElement addticketbutton;
    @FindBy (id = "title")
    WebElement tickettitlebox;
    @FindBy(xpath = "//div[@id='s2id_client_id']")
    WebElement ticketclientdrpdwn;
    @FindBy (xpath = "//input[@id='s2id_autogen7_search']")
    WebElement clientsearchbox;
    @FindBy (id="description")
    WebElement ticketdescriptionbox;
    @FindBy (xpath = "//button[@class='btn btn-primary']")
	WebElement savebtn;
    @FindBy (id="ajaxModalContent")
    WebElement addticketmodal;
    @FindBy(xpath="//input[@type='search']")
	WebElement srchbox;
    @FindBy (xpath = "//span[@class='dropdown inline-block']")
    WebElement action;
    @FindBy (xpath ="//a[@title='Assign myself in this ticket']")
    WebElement assigntomebutton;
    @FindBy (xpath = "(//td[@class=' w10p']//following::a)[3]")
    WebElement assignedTofield;
    @FindBy (xpath ="//a[@title='Mark as Closed']")
    WebElement markclosedbutton;
    @FindBy (xpath = "//div[text()='The record has been saved.']")
    WebElement savenotificationmsg;
    @FindBy (xpath="//span[text()='Closed']")
    WebElement statusfield;
    @FindBy (xpath ="//div[text()='Ticket closed']" )
    WebElement closednotificationmsg;
       
	public QALegendTicketPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	public void clickOnAddTicketButton() 
	{
		pageutilities.javaScriptClick(addticketbutton);
	
	}
	public void addTicket(String title,String description,String client)
	{
		pageutilities.enterText(tickettitlebox, title);
		pageutilities.clickOnElement(ticketclientdrpdwn);
		pageutilities.clickOnElement(clientsearchbox);
		pageutilities.enterText(clientsearchbox, "123");
		pageutilities.pageDownKeyPress();
		pageutilities.EnterKeyPress();
		pageutilities.enterText(ticketdescriptionbox, description);
		pageutilities.clickOnElement(savebtn);
	}
	public void searchTicketAdded(String title) throws InterruptedException
	{
		WaitUtility.waitForInVisiblityOfElement(driver, addticketmodal);
		pageutilities.javaScriptClick(srchbox);
		pageutilities.enterText(srchbox, title);
	}
	public String assignTicketToLoggedUser()
	{
		pageutilities.clickOnElement(action);
		pageutilities.clickOnElement(assigntomebutton);
		WaitUtility.waitForInVisiblityOfElement(driver, savenotificationmsg);
		String assigneduser=pageutilities.readText(assignedTofield);
		return assigneduser;
		
	}
	public String markTicketToClosed()
	{
		pageutilities.clickOnElement(action);
		pageutilities.clickOnElement(markclosedbutton);
		WaitUtility.waitForInVisiblityOfElement(driver, closednotificationmsg);
		String status=pageutilities.readText(statusfield);
		return status;
	}
}
