package com.qa.hotel_aynur.pages;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotel_aynur.base.BasePage;
import com.qa.hotel_aynur.util.ElementUtil;
import com.qa.hotel_aynur.util.JavaScriptUtil;

public class Star_4_Hotels extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;	
	
	By star4=By.id("f-star-rating-4");
	By distance=By.linkText("Distance");
	By hotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(), 'Airport')]");
    By hotelnames=By.xpath("//*[@class='hotel-wrap']//h3");	

	
	   public Star_4_Hotels(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);
		
	}
	
	public void Star_4_toAirport() throws InterruptedException {
		elementUtil.getElement(star4).click();
        
		
        for(int second = 0;; second++){
        	if(second >=20){
        		break;
        	}
        javaScriptUtil.scrollDownPage(1000, driver);
        	Thread.sleep(3000);
        }
        
        List<WebElement> hotelNames = driver.findElements(hotelnames);
        List<WebElement> miles = driver.findElements(hotelMiles);
                
        for (int i = 0; i < miles.size(); i++) {
        String text = hotelNames.get(i).getText();
        String text1 = miles.get(i).getText();
        String hotelMilesradius=text1.substring(0,3);
        double radius = Double.parseDouble(hotelMilesradius);
        
        if (radius<10) {
        	
        	System.out.println(hotelNames.get(i).getText() + " " + radius);
	
	
}
}	
    	System.out.println("Total Hotels found: "+hotelNames.size());

}	
	
}
