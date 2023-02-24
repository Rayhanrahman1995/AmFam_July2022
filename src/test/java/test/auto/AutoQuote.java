package test.auto;

import org.testng.annotations.Test;
import com.base.BaseClass;

public class AutoQuote extends BaseClass{
	
	@Test
	public void autoTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.startNewQuoteBtn();
	}

}
