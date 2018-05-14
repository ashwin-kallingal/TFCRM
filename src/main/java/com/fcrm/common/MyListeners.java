package com.fcrm.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.fcrm.utilities.Excel;
import com.fcrm.utilities.Utility;

public class MyListeners implements ITestListener
{
	
	public static int passCount=0;
	public static int failCount=0;
	public static int skipCount=0;

	@Override
	public void onFinish(ITestContext result) 
	{
		Reporter.log("Pass Count:"+passCount, true);
		Reporter.log("Fail Count:"+failCount, true);
		Reporter.log("Skip Count:"+skipCount, true);
		
	}

	@Override
	public void onStart(ITestContext result) 
	{		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		Excel.setCellValue(result.getName(), "FAIL", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		Utility.getDesktopScreenshot(AutomationConstant.SCREENSHOT_PATH);
		failCount++;		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Excel.setCellValue(result.getName(), "SKIP", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		skipCount++;
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Excel.setCellValue(result.getName(), "PASS", Utility.getFormattedDateTime(), BaseTest.myBrowser);
		passCount++;		
	}
}