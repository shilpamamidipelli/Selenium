package DriverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import Constants.TestConstants;
import TheInternet.ExceptionHandling; 
import TheInternet.ReadConfigPropertiesForInternet;
//import Utils.UtilityForInternet;
//import theInternetTestSuite.ConstantsTest;
//import TheInternet.CheckBoxPage;
//import org.openqa.selenium.By;

public class DriverFactory {

	public WebDriver driver;
	protected String headless;
	protected ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
	//private By checkBoxlinkLocator = By.linkText("Checkboxes");
	public  WebDriver openBrowser() {
		try {
			this.driver = chooseBrowser(prop.getProperty(TestConstants.browserNameHomePage));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.driver;
	}

	public WebDriver chooseBrowser(String browserName) throws Exception {
		headless = prop.getProperty("headless");
		switch (browserName) {
		case "Chrome":
			ChromeOptions co = new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				co.addArguments("--headless");
			}
			this.driver = new ChromeDriver(co);
			break;

		case "Edge":
			EdgeOptions eo = new EdgeOptions();
			if (headless.equalsIgnoreCase("true")) {
				eo.addArguments("--headless");
			}
			this.driver = new EdgeDriver(eo);
			break;

		case "Firefox":
			FirefoxOptions fo = new FirefoxOptions();
			if (headless.equalsIgnoreCase("true")) {
				fo.addArguments("--headless");
			}
			this.driver = new FirefoxDriver(fo);
			break;

		case "Safari":

			SafariOptions so = new SafariOptions();
			if (headless.equalsIgnoreCase("true")) {
				so.setCapability("headless", headless);
			}
			this.driver = new SafariDriver(so);
			break;

		default:
			throw new ExceptionHandling("Please give chrome / edge / firefox / Safari as browser name");
		}
		this.driver.manage().deleteAllCookies();
		this.driver.manage().window().maximize();
		return this.driver;
	}


	public void closeBrowser() {
		this.driver.close();
	}
}
