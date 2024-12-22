package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtilities;

public class QALegendMessagePage 
{
	
	public QALegendMessagePage(WebDriver driver)
	{
		this.driver=driver;
		this.pageutilities=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	public WebDriver driver;
	public PageUtilities pageutilities;
	@FindBy (xpath="//a[@title='Send message']")
	WebElement composemail;
	@FindBy (id="s2id_to_user_id")
	WebElement Tomailldbox;
	@FindBy (id="s2id_autogen3_search")
	WebElement Tomailldsearchbox;
	@FindBy (id="select2-result-label-907")
	WebElement TomailIddrpdwn;
	@FindBy (name="subject")
	WebElement subjectbox;
	@FindBy (xpath = "//textarea[@name='message']")
	WebElement messagetext;
	@FindBy (xpath ="//button[@type='submit']")
	WebElement sendbutton;
	@FindBy (xpath = "(//a[starts-with(@class,'list-group-item')])[3]")
	WebElement sentitems;
	@FindBy (id="search-messages")
	WebElement searchtxtbox;
	@FindBy (xpath = "//div[@class='media-body']")
	WebElement emailbody;
	@FindBy (xpath = ("//p[@class='pt5 pb10 b-b']//following::p"))
	WebElement emailmessage;	
	
	public void addMessage(String mailid,String subject,String msg)
	{
		pageutilities.clickOnElement(composemail);
		pageutilities.clickOnElement(Tomailldbox);
		pageutilities.enterText(Tomailldsearchbox, mailid);
		pageutilities.EnterKeyPress();
		pageutilities.enterText(subjectbox, subject);
		pageutilities.enterText(messagetext, msg);
		pageutilities.clickOnElement(sendbutton);
		
	}	
	
	public void getMessageOnSentItems(String str) throws InterruptedException
	{
		pageutilities.javaScriptClick(sentitems);
		searchtxtbox.sendKeys(str);
	}
	
	public String getMessageAdded()
	{
		pageutilities.clickOnElement(emailbody);
		String sub=pageutilities.readText(emailmessage);
		return sub;
	}
	
}
