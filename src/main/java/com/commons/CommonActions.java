package com.commons;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.reporting.Logs;

public class CommonActions {


	public static void click(WebElement element) {
		element.click();
		Logs.log(element+" ----> has been clicked");
	}
	
	public static void validate(WebElement element,String expected) {
		String actual=element.getText();
		Logs.log("Validating ---> actual: "+actual+"*** Expected: "+expected);
		Assert.assertEquals(actual, expected);
	}
	
	
}
