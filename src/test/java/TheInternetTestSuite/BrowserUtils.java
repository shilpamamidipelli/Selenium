package TheInternetTestSuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import seleniumsessions.ExceptionHandling;
import seleniumsessions.ReadConfigProperties;

public class BrowserUtils {

	WebDriver driver;

	String headless;

	public WebDriver openBrowser(String browserName) throws Exception {

		try {
			headless = ReadConfigProperties.readProp("headless");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (browserName) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			if (headless.equalsIgnoreCase("headless")) {
				co.addArguments("--headless");
			}
			this.driver = new ChromeDriver(co);
			break;

		case "Edge":
			EdgeOptions eo = new EdgeOptions();
			if (headless.equalsIgnoreCase("headless")) {
				eo.addArguments("--headless");
			}
			this.driver = new EdgeDriver(eo);
			break;

		case "FireFox":
			FirefoxOptions fo = new FirefoxOptions();
			if (headless.equalsIgnoreCase("headless")) {
				fo.addArguments("--headless");
			}
			this.driver = new FirefoxDriver(fo);
			break;

		case "Safari":

			SafariOptions so = new SafariOptions();
			if (headless.equalsIgnoreCase("headless")) {
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

}
