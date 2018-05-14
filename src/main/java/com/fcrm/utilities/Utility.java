package com.fcrm.utilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility 
{	
	public static String getFormattedDateTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
		return sdf.format(new Date());
	}
	
	public static String getScreenshot(WebDriver driver, String name) throws IOException
	{
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			
			String destFile = "F://TFCRM//FCRM-Automation//snap"+"/"+getFormattedDateTime()+"-"+name+".png";
			File finaldestFile = new File(destFile);
			FileUtils.copyFile(srcFile, finaldestFile);			
			
		return destFile;
	}	
	
	public static void getDesktopScreenshot(String imgFolderPath)
	{
		String timeStamp = getFormattedDateTime();
		
		try
		{
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle scrnRect = new Rectangle(d);
			
			Robot r = new Robot();
			BufferedImage img = r.createScreenCapture(scrnRect);
			File output = new File(imgFolderPath+timeStamp+".png");
			ImageIO.write(img, "png", output);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}