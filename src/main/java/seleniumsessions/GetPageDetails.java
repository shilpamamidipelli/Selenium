package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageDetails {

	public static void main(String[] args) throws InterruptedException, NoSuchFieldException, SecurityException {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naveenautomationlabs.com/opencart/");
		// System.out.println(driver.getTitle());
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		String title = driver.getTitle();
		System.out.println("The the page title is "+title);
		driver.navigate().to("https://google.com");
		driver.manage().window().maximize();
		// wait (i ) untill : fluent wait (c) -- webdriver wait (c) 
		// implicit wait 
		Thread.sleep(1000);
		 driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(1000);
		String currentUrl =  driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.quit();
	}
}
