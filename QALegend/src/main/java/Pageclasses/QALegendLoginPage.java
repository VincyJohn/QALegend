package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import dev.failsafe.internal.util.Assert;

public class QALegendLoginPage 
{
	public WebDriver driver;
	public PageUtilities pageutilities;
	@FindBy (id="email")
	WebElement usernamefield;
	@FindBy (id="password")
	WebElement passwordfield;
	@FindBy (xpath = "//button[text()='Sign in']")
	WebElement signinbutton;
	@FindBy (xpath = "//div[@class='alert alert-danger']")
	WebElement invalidloginerror;
	public QALegendLoginPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public void login(String username,String password)
	{
		pageutilities.enterText(usernamefield, username);
		pageutilities.enterText(passwordfield, password);
		pageutilities.clickOnElement(signinbutton);
	}
	public Boolean invalidLoginValidation()
	{
		return pageutilities.isElementDispalyed(invalidloginerror);
	}
}
	