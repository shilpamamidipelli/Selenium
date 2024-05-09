package seleniumsessions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		ElementUtil util = new ElementUtil(driver);
		driver.get("https://the-internet.herokuapp.com");
		String parentWindowId = driver.getWindowHandle();
		By NewWindowLink =By.xpath("//a[text()='Click Here']"); 
		By windowsTestPageLink = By.xpath("//a[contains(text(),\"Multiple\")]");
		util.scrollToElement(windowsTestPageLink);
		util.clickOnLocator(NewWindowLink);
		util.closeAllWindowsExceptParent(parentWindowId);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		parentWindowId = driver.getWindowHandle();
		Thread.sleep(1000);
		By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
		By meta = By.xpath("//a[contains(@href,'facebook')]");
		By xtwitter = By.xpath("//a[contains(@href,'twitter')]");
		By youTube = By.xpath("//a[contains(@href,'youtube')]");
		util.clickOnLocator(linkedin);
		util.clickOnLocator(meta);
		util.clickOnLocator(xtwitter);
		util.clickOnLocator(youTube);
		util.closeAllWindowsExceptParent(parentWindowId);
	}
	
	public void function2() {
		
	}
	
	public void function3() {
		
	}
}

