package com.testng.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends TestListenerAdapter {

	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	private ExtentTest test;
	private String screenshotDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "/test-output/screenshots/";

	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + System.getProperty("file.separator")
				+ "/test-output/ExtentReports.html");
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		// htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Envionment", "QA");
		extent.setSystemInfo("user", "sanjana");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test failed");
		try {
			test.fail("Screenshot: " + test.addScreenCaptureFromPath(screenshotDir + result.getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
