package Hotelscom_aynur.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotel_aynur.base.BasePage;
import com.qa.hotel_aynur.pages.HomePage;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homepage;
	
	@BeforeMethod(alwaysRun=true)
	public void setup(){
		basePage = new BasePage();
		properties = basePage.initialize_Properties();
		driver = new BasePage().initialize_driver();
		homepage = new HomePage(driver);	
	}
	
	@Test(priority = 1,description = "Check home page title")
	public void TestCaseOne1() throws InterruptedException {
		homepage.putInformation();
		String actualTitle = homepage.getPageTitle();
		String expectedTitle="Hotels.com - hotels in Boston, Massachusetts, United States of America";
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	
	
	@Test(priority = 2)
	public void TestCaseOne2() throws InterruptedException {
		homepage.putInformation();
		homepage.verifyHilton();
		
	}
	@Test(priority = 3)
	public void TestCaseOne3() throws InterruptedException {
		homepage.putInformation();
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}
}