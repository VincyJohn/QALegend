package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendTicketPage 
{

	public WebDriver driver;
	public PageUtilities pageutilities;
    @FindBy (xpath = "//a[@title='Add ticket']")
    WebElement addticketbutton;
	public QALegendTicketPage(WebDriver driver) 
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver,this);
	}
	public void clickOnAddTicketButton() 
	{
		pageutilities.clickOnElement(addticketbutton);
	}

}
