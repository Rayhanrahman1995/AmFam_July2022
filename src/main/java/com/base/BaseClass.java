package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import static com.utils.IConstant.*;
import java.lang.reflect.Method;
import java.time.Duration;
import com.aventstack.extentreports.Status;
import com.objects.AddressPage;
import com.objects.GetAQuotePage;
import com.objects.LandingPage;
import com.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExtentListner{

	protected WebDriver driver;
	protected LandingPage landingPage;
	protected GetAQuotePage getAQuotePage;
	protected AddressPage addressPage;
	ReadProperties readProperties=new ReadProperties();
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUpBrowser(String browser) {
	//String browser=readProperties.getProperty(BROWSER);
	String url=readProperties.getProperty(URL);
    long pageloadWait=readProperties.getWaitProperty(PAGELOAD_WAIT);
    long explicitlyWait=readProperties.getWaitProperty(EXPLICITLY_WAIT);
	
	
	initDriver(browser);
	initClasses(driver);
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadWait));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(explicitlyWait));
	}
	
	private void initClasses(WebDriver driver) {
		landingPage=new LandingPage(driver);
		getAQuotePage=new GetAQuotePage(driver);
		addressPage=new AddressPage(driver);
	}
	
	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
	}
	
	@AfterMethod
	public void getResults(ITestResult result, Method method) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		}else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver,method.getName()));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
		
	}
	
	@AfterMethod
	protected void tearUp() {
		driver.quit();
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}
	
}
