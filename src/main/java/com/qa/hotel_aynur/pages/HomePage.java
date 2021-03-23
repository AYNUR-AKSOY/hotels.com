package com.qa.hotel_aynur.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import com.qa.hotel_aynur.base.BasePage;
import com.qa.hotel_aynur.util.JavaScriptUtil;
import java.util.List;
import com.qa.hotel_aynur.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	By destination=By.id("qf-0q-destination");
	By checkIn=By.id("qf-0q-localised-check-in");
	By checkOut=By.id("qf-0q-localised-check-out");
	By checkRoom=By.id("qf-0q-rooms");
	By checkAdult=By.id("qf-0q-room-0-adults");
	By checkChild=By.id("qf-0q-room-0-children");
	By child1=By.id("qf-0q-room-0-child-0-age");
	By child2=By.id("qf-0q-room-0-child-1-age");
	By search=By.xpath("//button[@type='submit']");
	By star3=By.id("f-star-rating-3");
	By hotelList = By.xpath("//li//a[@class='property-name-link'][contains(text(),'')] ");

	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);
	}
	
	public void putInformation() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement roomElement=driver.findElement(checkRoom);
		WebElement adultElement=driver.findElement(checkAdult);
		WebElement childrenElement=driver.findElement(checkChild);
		
		Select roomSelect=new Select(roomElement);
		Select adultsSelect=new Select(adultElement);
		Select childrenSelect=new Select(childrenElement);
		
		driver.findElement(destination).sendKeys("Boston, Massachusetts, United States of America");
		driver.findElement(checkIn).clear();
		driver.findElement(checkIn).sendKeys("04/08/21");
		driver.findElement(checkOut).clear();
		driver.findElement(checkOut).sendKeys("04/12/21");
		roomSelect.selectByValue("1");
		adultsSelect.selectByValue("2");
		childrenSelect.selectByValue("2");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement childOneElement=driver.findElement(child1);
		WebElement childTwoElement=driver.findElement(child2);
		Select childOneSelect=new Select(childOneElement);
		Select childTwoSelect=new Select(childTwoElement);
		childOneSelect.selectByValue("4");
		childTwoSelect.selectByValue("9");
		driver.findElement(search).click();
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public void verifyHilton() throws InterruptedException {
		
        elementUtil.getElement(star3).click();
        Thread.sleep(6000);
		 
		 for(int second = 0;; second++){
				if(second >=60){
					break;
				}
		javaScriptUtil.scrollDownPage(1000, driver);
				
				Thread.sleep(3000);
			}	
		 List<WebElement>hotels=driver.findElements(hotelList);
					System.out.println(hotels.size()+"="+ " 3 stars otels ");
					for (int i = 0; i < hotels.size(); i++) {
						String text = hotels.get(i).getText();
						System.out.println(text);
						if (text.contains("Hilton")) {
							System.out.println("This hilton hotel is available " + text);
							
}
		
}
}
}