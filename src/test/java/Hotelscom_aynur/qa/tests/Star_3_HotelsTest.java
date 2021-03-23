package Hotelscom_aynur.qa.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotel_aynur.base.BasePage;
import com.qa.hotel_aynur.pages.HomePage;
import com.qa.hotel_aynur.pages.Star_3_Hotels;
import com.qa.hotel_aynur.util.ElementUtil;
public class Star_3_HotelsTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homepage;
	ElementUtil elementUtil;
    Star_3_Hotels threeStarhotels;
    
     
        @BeforeTest
        public void setUp() throws InterruptedException {
        	basePage = new BasePage();
    		properties = basePage.initialize_Properties();
    		driver = new BasePage().initialize_driver();
    		homepage = new HomePage(driver);
    		threeStarhotels=new Star_3_Hotels(driver);
    		
    	}
	
	
	@Test(enabled=true)
	
	   public void  Citycenterverify() throws InterruptedException {
		homepage.putInformation();
		threeStarhotels.Star_3_toAirport();
		}
	
	@AfterTest
	public void tearDown() {
	driver.quit();

	}
}



