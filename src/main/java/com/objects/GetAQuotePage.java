package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.commons.CommonActions.*;

public class GetAQuotePage {
    
	public GetAQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".h1")
	WebElement getAQuotePageTitle;
	@FindBy(xpath = "//input[@id='uid_60']")
	WebElement zipCode;
	@FindBy(xpath = "//div[@value='Car']")
	WebElement carLobBtn;
	@FindBy(xpath = "//div[@value='Home']")
	WebElement homeLobBtn;
	@FindBy(className = "LoadingButton__content")
	WebElement letsGoBtn;
	
	public void validateGetAQuotePageTitle(String expected) {
		validate(getAQuotePageTitle, expected);
	}
	
	public void insertZipCode(String value) {
		insert(zipCode, value);
	}
	
	public void clickCarLob() {
		click(carLobBtn);
	}
	
	public void clickLetsGoBtn() {
		click(letsGoBtn);
	}
	
	public void clickHomeLobBtn() {
		click(homeLobBtn);
	}
}
