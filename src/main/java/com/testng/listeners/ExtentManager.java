package com.testng.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	private static String reportPath;

	// private constructor to prevent initialization
	private ExtentManager() {

	}

	// Initialize extent reports instance
	public static ExtentReports getExtentReports() {
		if (extent == null) {
			reportPath = System.getProperty("user.dir") + "/test-output/ExtentReports/";

			// create report folder if it does not exists
			File reportFolder = new File(reportPath);
			if (!reportFolder.exists()) {
				reportFolder.mkdirs();
			}

			// set the report file name with current date and time to avoid overwriting
			String fileName = "ExtentReports-" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String filePath = reportPath + fileName;

			// Initialize HTML reporter
			htmlReporter = new ExtentHtmlReporter(filePath);
			htmlReporter.config().setDocumentTitle("Salesforce Automation Test Report");
			htmlReporter.config().setReportName("Test Execution Results");
			htmlReporter.config().setTheme(Theme.STANDARD);

			// Initialize the ExtentReports object and attach the HTML reporter
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		return extent;
	}

	// Create an ExtentTest instance for logging test steps
	public static ExtentTest createTest(String testName, String description) {
		return getExtentReports().createTest(testName, description);
	}

	// Flush the report (write all data to the file)
	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}

}
