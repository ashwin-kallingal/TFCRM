package com.fcrm.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fcrm.utilities.Property;
/*Author:Ashwin Kallingal*/
public class BasePage 
{
	public Logger log=Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String config;
	public long timeout;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		config=AutomationConstant.CONFIG_FILE;
		timeout=Long.parseLong(Property.getPropertyValue(config, "EXPLICIT"));		
	}
	
	public void waitForElementPresent(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(ele));		
	}
	
	public void verifyURLIs(String eURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlToBe(eURL));		
	}
	
	public void verifyURLHas(String eURL)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.urlContains(eURL));		
	}
}
