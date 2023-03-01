package test.auto;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.base.BaseClass;
import com.reporting.Logs;

public class AutoQuote extends BaseClass{
	
	@Test(priority = 1, enabled = false, groups = "auto",dependsOnMethods = "nonFunctionalTest",invocationCount = 2)
	public void autoTest() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.startNewQuoteBtn();
		//getAQuotePage.validateGetAQuotePageTitle(" Get a Quote ");
		getAQuotePage.insertZipCode("54115");
		getAQuotePage.clickCarLob();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyCityAndState("Verify your city and state");
	}
	
	@Test(priority = 2, enabled = true, groups = "auto")
	public void autoTest1() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
		landingPage.startNewQuoteBtn();
		//getAQuotePage.validateGetAQuotePageTitle(" Get a Quote ");
		getAQuotePage.insertZipCode("54115");
		getAQuotePage.clickCarLob();
		getAQuotePage.clickLetsGoBtn();
		Assert.fail();
		addressPage.verifyCityAndState("Verify your city and state");
	}
	
	@Test(priority = 3,enabled = false,groups = "non-functional", retryAnalyzer = com.retry.RetryFailTests.class)
	public void nonFunctionalTest() {
		Logs.log("Validation non functional");
		AssertJUnit.fail();
	}
	
	@Test(priority = 4,groups = "non-functional",enabled = false)
	public void retryAnnotationTransformTest() {
		Logs.log("Validation non functional");
		AssertJUnit.fail();
	}

}
