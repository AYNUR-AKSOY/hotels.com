package Hotelscom_aynur.qa.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotel_aynur.base.BasePage;
import com.qa.hotel_aynur.pages.Star_4_Hotels;
import com.qa.hotel_aynur.pages.HomePage;
import com.qa.hotel_aynur.pages.Star_3_Hotels;
import com.qa.hotel_aynur.pages.Star_5_Hotels;
import com.qa.hotel_aynur.util.ElementUtil;
public class Star_5_HotelsTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	ElementUtil elementUtil;
    Star_3_Hotels threeStarHotels;
    Star_4_Hotels fourStarHotels;
    Star_5_Hotels fiveStarHotels;
    
        @BeforeTest
        public void setUp() throws InterruptedException {
        	basePage = new BasePage();
    		properties = basePage.initialize_Properties();
    		driver = new BasePage().initialize_driver();
    		homePage = new HomePage(driver);
            threeStarHotels=new Star_3_Hotels(driver);
    		fourStarHotels=new  Star_4_Hotels(driver);
    		fiveStarHotels=new Star_5_Hotels(driver);
    	}
	
	
	@Test(enabled=true)
	
	   public void  Citycenterverify() throws InterruptedException {
		homePage.putInformation();
		fiveStarHotels.Star_5_toAirport();
		}
	
	
	@AfterTest
	public void tearDown() {
	driver.quit();

	}
}

