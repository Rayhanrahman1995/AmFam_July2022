package test.home;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.reporting.Logs;

public class HomeQuoteTest extends BaseClass{

	@Test(priority = 1, groups = "home")
	public void homeQuoteTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.startNewQuoteBtn();
		//getAQuotePage.validateGetAQuotePageTitle(" Get a Quote ");
		getAQuotePage.insertZipCode("54115");
		getAQuotePage.clickHomeLobBtn();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyCityAndState("Verify your city and state");
	}
	
	@Test(priority = 2, groups = "non-functional")
	public void nonFunctionalTest(){
		Logs.log("Validation non functional");
	}
	
	
}
