package com.testng.listeners;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
//Thread local to store the ExtentTest instance for each test method (ensuring thread safety)
	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	// This method is used to set the ExtentTest instance for the current test
	public static void setExtentTest(ExtentTest test) {
		extenttest.set(test);
	}

	// This method is used to set the ExtentTest instance for the current test
	public static ExtentTest getExtentTest() {
		return extenttest.get();
	}

	// This method is used to log information in the ExtentTest for the current test
	public static void logInfo(String message) {
		getExtentTest().info(message);
	}

	// This method is used to log a pass status in the ExtentTest for the current
	// test
	public static void logPass(String message) {
		getExtentTest().pass(message);
	}

	// This method is used to log a fail status in the ExtentTest for the current
	// test
	public static void logFail(String message) {
		getExtentTest().fail(message);
	}

	// This method is used to log a warning status in the ExtentTest for the current
	// test
	public static void logWarning(String message) {
		getExtentTest().warning(message);
	}

	// This method is used to attach a screenshot in the ExtentTest for the current
	// test
	public static void attachScreenshot(String screenshotPath) {
		try {
			getExtentTest().addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			logFail("Failed to attach screenshot " + e.getMessage());

		}
	}

	// This method is used to remove the current ExtentTest instance from
	// ThreadLocal
	public static void removeExtentTest() {
		extenttest.remove();
	}

}
