package com.fcrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fcrm.common.AutomationConstant;
import com.fcrm.common.BasePage;
import com.fcrm.utilities.Property;

public class HomePage extends BasePage
{
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.cfm?logout=1']")
	public WebElement logoutBtn;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);		
	}
	
	public void testLogout()
	{
		driver.switchTo().frame("mainpanel");
		waitForElementPresent(logoutBtn);
		logoutBtn.sendKeys(Keys.ENTER);
		
		verifyURLHas(Property.getPropertyValue(AutomationConstant.CONFIG_FILE, "LOGINPAGE"));
	}
}
