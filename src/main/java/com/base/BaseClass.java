package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.utils.IConstant.*;
import java.time.Duration;

import com.objects.LandingPage;
import com.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	protected LandingPage landingPage;
	ReadProperties readProperties;
	
	@BeforeSuite
	public void setUpSuite() {
		readProperties=new ReadProperties();
	}
	
	@BeforeMethod
	public void setUpBrowser() {
	String browser=readProperties.getProperty(BROWSER);
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
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void closingWindows() {
		driver.quit();
	}
	
	
	
	
}
