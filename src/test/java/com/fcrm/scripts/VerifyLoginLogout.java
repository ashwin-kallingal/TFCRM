package com.fcrm.scripts;

import org.testng.annotations.Test;
import com.fcrm.common.BaseTest;
import com.fcrm.pages.HomePage;
import com.fcrm.pages.LoginPage;
import com.fcrm.utilities.Excel;

public class VerifyLoginLogout extends BaseTest
{	
	public VerifyLoginLogout()
	{
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
	@Test(priority=3, groups= {"smoke"}, enabled=false)
	
	public void testLoginLogout1() throws InterruptedException
	{
		String usn = Excel.getCellValue(INPUT_FILE, INPUT_SHEET, 1, 0);
		String pwd = Excel.getCellValue(INPUT_FILE, INPUT_SHEET, 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.testLogin(usn, pwd);
		
		Thread.sleep(10000);
		
		HomePage hp = new HomePage(driver);
		hp.testLogout();
		
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
    @Test(priority=1,groups= {"smoke"}, enabled=true)
	
   	public void testLoginLogout2() throws InterruptedException
	{
		String usn = Excel.getCellValue(INPUT_FILE, MULTIPLE_SHEET, 1, 0);
		String pwd = Excel.getCellValue(INPUT_FILE, MULTIPLE_SHEET, 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.testLogin(usn, pwd);
		
		Thread.sleep(10000);
		
		HomePage hp = new HomePage(driver);
		hp.testLogout();
		
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
    @Test(priority=2, groups={"regression"},enabled=false)
	
   	public void testLoginLogout3() throws InterruptedException
	{
    	String usn = Excel.getCellValue(INPUT_FILE, MULTIPLE_SHEET, 2, 0);
		String pwd = Excel.getCellValue(INPUT_FILE, MULTIPLE_SHEET, 2, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.testLogin(usn, pwd);
		
		Thread.sleep(10000);
		
		HomePage hp = new HomePage(driver);
		hp.testLogout();	
		
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}	
}