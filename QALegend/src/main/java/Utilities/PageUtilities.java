package Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities
{
	private WebDriver driver;
	
	public PageUtilities(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public void selectByIndex(WebElement dropdown,int index)
	{
		Select drpdwn =new Select(dropdown);
		drpdwn.selectByIndex(index);
	}
	
public void selectByVisibleText(WebElement dropdown,String text)
{
	
	Select drpdwn =new Select(dropdown);
	drpdwn.selectByVisibleText(text);
}

public void selectByValue(WebElement dropdown,String value)
{
	
	Select drpdwn =new Select(dropdown);
	drpdwn.selectByValue(value);
}

public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination)
{
	Actions action= new Actions(driver);
	action.dragAndDrop(source, destination);
	action.build().perform();
}

public void mouseHover(WebElement element)
{
	Actions action= new Actions(driver);
	action.moveToElement(element).build().perform();
	
}
public void rightClick()
{
	Actions action= new Actions(driver);
	action.contextClick().build().perform();
}
public void enterText(WebElement element,String text)
{
	element.sendKeys(text);
}
public void javaScriptClick(WebElement element)
{
	JavascriptExecutor jsc=(JavascriptExecutor)driver;
	jsc.executeScript("arguments[0].click();",element);

}
public void scrollDown()
{
	JavascriptExecutor jsc=(JavascriptExecutor)driver;
	jsc.executeScript("Window.scrollBy(0,1000)");
	
}
public void scrollUp()
{
	JavascriptExecutor jsc=(JavascriptExecutor)driver;
	jsc.executeScript("Window.scrollBy(1000,0)");
	
}
public void javascriptScrollElementToView(WebElement element)
{
	JavascriptExecutor jsc=(JavascriptExecutor)driver;
	jsc.executeScript("arguments[0].scrollIntoView(true);",element);
}
public void doubleClick()
{
	Actions action= new Actions(driver);
	action.doubleClick().build().perform();
}

public String readText(WebElement element)
{
	return element.getText();
	
}
public String readAttribute(WebElement element,String attribute)
{
	return element.getAttribute(attribute);
	
}
public void clearTextField(WebElement element)
{
	element.clear();
}
public void selectCheckbox(WebElement checkbox)
{
	if (!checkbox.isSelected())
	{
	checkbox.click();
	}
}
public void unselectCheckbox(WebElement checkbox)
{
	if (checkbox.isSelected())
	{
	checkbox.click();
	}
}

public void selectRadiobutton(WebElement radiobutton)
{
	if (!radiobutton.isSelected())
	{
		radiobutton.click();
	}
}
public void openUrl(WebDriver driver,String Url)
{
	driver.get(Url);
}
public void navigateToBackPage(WebDriver driver)
{
	driver.navigate().back();
}
public void navigateToForwardPage(WebDriver driver)
{
	driver.navigate().forward();
}
public void refreshPage(WebDriver driver)
{
	driver.navigate().refresh();
}
public Boolean isElementDispalyed(WebElement element)
{
	try
	{
	return element.isDisplayed();
	
	}
	catch (Exception e) 
	{
		return false;
	}
	
}
public Boolean isElementEnabled(WebElement element)
{
	try
	{
	return element.isEnabled();
	
	}
	catch (NoSuchElementException e) 
	{
		return false;
	}
	
}
public Boolean isElementSelected(WebElement element)
{
	try
	{
	return element.isSelected();
	
	}
	catch (NoSuchElementException e) 
	{
		return false;
	}
	
}
public void acceptAlert(WebDriver driver) 
{
	driver.switchTo().alert().accept();  
}
public void dismissAlert(WebDriver driver) 
{
	driver.switchTo().alert().dismiss(); 
	
}
public void navigateToChildWindow()
{
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	Set<String> tabs=driver.getWindowHandles();
	System.out.println(tabs);
	Iterator<String> I1=tabs.iterator();
	while (I1.hasNext())
	{
		String childwindow=I1.next();
		if(!parent.equals(childwindow))
		{
			driver.switchTo().window(childwindow);
		
		}
	}
}
public void escKeyPress()
{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.ESCAPE);
	action.build().perform();

}
public void EnterKeyPress()
{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.ENTER);
	action.build().perform();

}
public void ctrlKeyPress()
{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.CONTROL);
	action.build().perform();

}
public void pageDownKeyPress()
{
	Actions action=new Actions(driver);
	action.sendKeys(Keys.PAGE_DOWN);
	action.build().perform();

}
public static Boolean compareTwoStrings(String str1,String str2)
{
	if (str1.toLowerCase().equals(str2.toLowerCase()))
	{
	return true;
	}
	else
	{
	
	}
	return false;
	
}
}



