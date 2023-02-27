package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.commons.CommonActions.*;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(tagName = "h1") 
	WebElement landingPageTitle;
	@FindBy(xpath = "//button[contains(text(),'Start a New Quote')]") 
	WebElement startNewQuoteBtn;
	
	
	public void validateLandingPageTitle(String expected) {
		validate(landingPageTitle, expected);
	}
	
	public void startNewQuoteBtn() {
		click(startNewQuoteBtn);
	}
	
	
}
