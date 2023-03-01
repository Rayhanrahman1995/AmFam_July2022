package com.reporting;

import java.util.HashMap;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReporting {

	static HashMap<Long, ExtentTest> tests=new HashMap<>();
	public static ExtentTest extentTest;
	
	public static ExtentTest getTests(long processID) {
		return tests.get(processID);
	}
	
	public static ExtentTest createTest(String testName) {
		extentTest=ExtentTestManager.extentReports.createTest(testName);
		tests.put(Thread.currentThread().getId(), extentTest);
		return extentTest;
	}
	
	
	
	
	
	
}
