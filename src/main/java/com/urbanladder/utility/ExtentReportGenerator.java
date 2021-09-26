package com.urbanladder.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reporter;
	public static ExtentTest test;
	
	public static ExtentReports generateReport() {
		
		String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.html'").format(new Date());
		htmlReporter = new ExtentHtmlReporter(".//ExtentReports//UrbanLadder-"+out);
	    reporter = new ExtentReports();
	    reporter.attachReporter(htmlReporter);
	    
	    reporter.setSystemInfo("OS", "Windows 10");
	    reporter.setSystemInfo("Host Name", "SG");
	    reporter.setSystemInfo("Environment", "QA");
	    reporter.setSystemInfo("User Name", "Guptayashu99");

	    htmlReporter.config().setChartVisibilityOnOpen(true);
	    htmlReporter.config().setDocumentTitle("Automation Test Report for Urban Ladder");
	    htmlReporter.config().setReportName("Test Report for Functional Testing");
	    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    return reporter;
		
	}
	
	public static void getResult(ITestResult result) {
	if (result.getStatus() == ITestResult.FAILURE) {
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +  "Test case FAILED due to below issues:",
	ExtentColor.RED));
	test.fail(result.getThrowable());
	} else if (result.getStatus() == ITestResult.SUCCESS) {
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +  "Test Case PASSED", ExtentColor.GREEN));
	} else {
	test.log(Status.SKIP,
	MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	test.skip(result.getThrowable());
	}
	}
		
}
