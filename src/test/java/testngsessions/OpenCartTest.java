package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	@BeforeSuite
	
	public void dbConnection() {
		
	}
	
	@BeforeTest 
	
	public void createUser() {
		
	}
	
	@BeforeClass 
	
public void launchbrowser() {
		
	}
	
	@BeforeMethod
	
public void login() {
		
	}
	
	
	@Test
	
public void loginTest() {
		
	}
	
	
	@Test
	
public void regsiterTest() {
		
	}
	
	@Test
	
public void NavigateTest() {
		
	}
	
	
	@AfterMethod
	
	
public void logoutTest() {
		
	}

	
	@AfterClass 

	
public void closeBrowser() {
		
	}
	
	@AfterTest

public void deleteUser() {
		
	}
	
	@AfterSuite

public void closeSession() {
		
	}
	
	
}
