package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWait {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://www.naveenautomationlabs.com/opencart/");
		driver.manage().window().maximize();
		By MyAccountlocator = By.xpath("//a[@title='My Account']");
		By Loginlocator = By.xpath("//a[text()='Login']");
		By emailLocator = By.xpath("//input[@id='input-email']");
		By passwordLocator = By.xpath("//input[@id='input-password']");
		By submitButton = By.xpath("//input[@type='submit']");
		By LinkText = By.linkText("Forgotten Password");
		By LoginLink = By.linkText("Login");
		By PartialLinkText = By.partialLinkText("Conti");
		waitForElementAndClick(MyAccountlocator);
		waitForElementAndClick(Loginlocator);
		waitForElementAndSendKeys(emailLocator);
		waitForElementAndSendKeys(passwordLocator);
		waitForElementAndClick(submitButton);
		
		waitForElementAndClick(LinkText);	
		waitForElementAndClick(LoginLink);
		
		waitForElementAndClick(PartialLinkText);
		
		
		// drawback in the above code is functionally the code is more readable 
		//driver.quit();
	}

	public static void waitForElementAndClick(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		ExpectedCondition<WebElement> element = ExpectedConditions.presenceOfElementLocated(locator);
		wait.until(element).click();
	}

	public static void waitForElementAndSendKeys(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(1000));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys("admin");

	}
}
