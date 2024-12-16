package com.testng.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtilities {

	public void takeScreenShot(WebDriver driver) {

		TakesScreenshot screenShot = ((TakesScreenshot) driver);
		
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		
		String userDir = System.getProperty("user.dir");
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(currentDate);
		
		
		String filePath =  userDir + "\\Screenshots\\screenshot" + timeStamp + ".jpeg";
		
		
		File destFile = new File(filePath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
