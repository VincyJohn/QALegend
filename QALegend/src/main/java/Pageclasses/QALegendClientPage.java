package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

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
	WebElement companyname;
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
	@FindBy (xpath = "//div[@id='s2id_currency']")
	WebElement Currency;
	@FindBy (id="s2id_autogen5_search")
	WebElement currencysearchbox;
	@FindBy (id="disable_online_payment")
	WebElement disableonlinepaymentcheckbox;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy (xpath = "//input[@type='search']")
	WebElement searchbox;
	public void clickOnAddClientButton() 
	{
		pageutilities.clickOnElement(addclientbutton);
	}
	public void addClient(String company,String addr,String city,String state,String country,String phone,String currency)
	{
		pageutilities.enterText(companyname,company);
		pageutilities.enterText(address,addr);
		pageutilities.enterText(City,city);
		pageutilities.enterText(State,state);
		pageutilities.enterText(Country,country);
		Phone.sendKeys(phone);
		/*pageutilities.javascriptScrollElementToView(Currency);
		pageutilities.javaScriptClick(Currency);
		pageutilities.enterText(currencysearchbox,currency);
		pageutilities.pageDownKeyPress();
		pageutilities.EnterKeyPress();*/
		pageutilities.javascriptScrollElementToView(disableonlinepaymentcheckbox);
		pageutilities.selectCheckbox(disableonlinepaymentcheckbox);
		pageutilities.clickOnElement(savebutton);
	}
	
	public void searchForAddedClient(String comp)
	{
		pageutilities.javascriptScrollElementToView(searchbox);
		pageutilities.javaScriptClick(searchbox);
		pageutilities.enterText(searchbox,comp);
		/*String client1=pageutilities.readText();
		return client1;*/
		
	}

}
