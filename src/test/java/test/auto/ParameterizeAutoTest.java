package test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.utils.PojoData;

public class ParameterizeAutoTest extends BaseClass{
	
	@Parameters({"expectedPageTitle","zipCode","verifyCityAndState"})
	@Test(priority = 1, enabled = false, groups = "auto")
	public void parameterizeAutoTest(String expectedPageTitle, String zipCode, String verifyCityAndState) {
		landingPage.validateLandingPageTitle(expectedPageTitle);
		landingPage.startNewQuoteBtn();
		//getAQuotePage.validateGetAQuotePageTitle(" Get a Quote ");
		getAQuotePage.insertZipCode(zipCode);
		getAQuotePage.clickCarLob();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyCityAndState(verifyCityAndState);
	}
	
	@Parameters({"expectedPageTitle","zipCode","verifyCityAndState"})
	@Test(priority = 1, enabled = true, groups = "auto")
	public void getPojoTestData(String expectedPageTitle, String zipCode, String verifyCityAndState) {
		PojoData pojoData=new PojoData(expectedPageTitle, zipCode, verifyCityAndState);
		landingPage.validateLandingPageTitle(pojoData.getLandingPageTitle());
		landingPage.startNewQuoteBtn();
		//getAQuotePage.validateGetAQuotePageTitle(" Get a Quote ");
		getAQuotePage.insertZipCode(pojoData.getZipCode());
		getAQuotePage.clickCarLob();
		getAQuotePage.clickLetsGoBtn();
		addressPage.verifyCityAndState(pojoData.getVerifyCityAndState());
	}
	
}
