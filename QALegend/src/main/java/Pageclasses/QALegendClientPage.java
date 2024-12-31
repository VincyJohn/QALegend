package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendClientPage 
{

	public QALegendClientPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public WebDriver driver;
	public PageUtilities pageutilities;
	@FindBy (xpath = "//a[@title='Add client']")
	WebElement addclientbutton;
	@FindBy (id="company_name")
	WebElement companynamebox;
	@FindBy (name="address")
	WebElement address;
	@FindBy (id="city")
	WebElement City;
	@FindBy (id="state")
	WebElement State;
	@FindBy (id="country")
	WebElement Country;
	@FindBy (name="phone")
	WebElement Phone;
	@FindBy (id="disable_online_payment")
	WebElement disableonlinepaymentcheckbox;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy (xpath = "//input[@type='search']")
	WebElement searchbox;
	@FindBy (id="ajaxModalContent")
	WebElement addclientmodal;
	@FindBy (xpath = "(//table[@id='client-table']//descendant::a)[1]")
	WebElement companyname;
	@FindBy (xpath="//a[@title='Edit client']")
	WebElement editclientbutton;
	public void clickOnAddClientButton() 
	{
		pageutilities.clickOnElement(addclientbutton);
	}
	public void addClient(String company,String addr,String city,String state,String country,String phone,String currency) throws InterruptedException
	{
		pageutilities.enterText(companynamebox,company);
		pageutilities.enterText(address,addr);
		pageutilities.enterText(City,city);
		pageutilities.enterText(State,state);
		pageutilities.enterText(Country,country);
		Phone.sendKeys(phone);
		pageutilities.javascriptScrollElementToView(disableonlinepaymentcheckbox);
		pageutilities.selectCheckbox(disableonlinepaymentcheckbox);
		pageutilities.clickOnElement(savebutton);
	}
	
	public String searchForAddedClient(String comp) throws InterruptedException
	{
		WaitUtility.waitForInVisiblityOfElement(driver, addclientmodal);
		pageutilities.javaScriptClick(searchbox);
		pageutilities.enterText(searchbox,comp);
		String client1=pageutilities.readText(companyname);
		return client1;
		
	}
	public String editNoteAdded(String addr)
	{
		pageutilities.clickOnElement(editclientbutton);
		pageutilities.clearTextField(address);
		pageutilities.enterText(address, addr);
		pageutilities.clickOnElement(savebutton);
		WaitUtility.waitForInVisiblityOfElement(driver, addclientmodal);
		pageutilities.clickOnElement(editclientbutton);
		String editedaddress=pageutilities.readText(address);
		System.out.println(editedaddress);
		return editedaddress;
		
	}

}
