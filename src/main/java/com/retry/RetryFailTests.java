package com.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailTests implements IRetryAnalyzer{

	
	int limit=2;
	int alreadyTried=0;
			
	
	@Override
	public boolean retry(ITestResult result) {
		if(alreadyTried < limit) {
			alreadyTried++;
			return true;
		}
		return false;
	}
	
	
}
