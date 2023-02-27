package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.commons.CommonActions.*;

public class AddressPage {
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "prefill-city-state-dialog-title")
	WebElement titleVerifyCityAndState;

	public void verifyCityAndState(String expected) {
		validate(titleVerifyCityAndState, expected);
	}

}
