package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.ConstantsValues;

public class WaitUtility
{
	
	public static void waitForClickingElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
				wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void waitForTextToBePresentInElement(WebDriver driver,WebElement element,String text)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void waitForElementToBeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForAttributeToBe(WebDriver driver,WebElement element,String attribute,String value)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}
	public static void waitForVisiblityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForInVisiblityOfElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(ConstantsValues.EXPLICITWAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
}
