package com.reporting;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;

public class Logs {

	static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void log(String msz) {
		logger.log(Level.INFO, msz);
		Reporter.log(msz + "<br>");
		ExtentReporting.extentTest.log(Status.PASS, msz);
	}
}
