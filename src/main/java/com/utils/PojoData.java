package com.utils;

public class PojoData {

	
	private String landingPageTitle;
	private String zipCode;
	private String verifyCityAndState;
	
	
	public PojoData(String landingPageTitle, String zipCode, String verifyCityAndState) {
		if(landingPageTitle == null || zipCode== null || verifyCityAndState==null) {
			throw new NullPointerException();
		}else {
			this.landingPageTitle=landingPageTitle;
			this.zipCode=zipCode;
			this.verifyCityAndState=verifyCityAndState;
		}
	}
	
	
	public String getLandingPageTitle() {
		return landingPageTitle;
	}
	
    public String getZipCode() {
		return zipCode;
	}
	
    public String getVerifyCityAndState() {
		return verifyCityAndState;
	}
	

}
