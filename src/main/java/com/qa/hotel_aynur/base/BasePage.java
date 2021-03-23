package com.qa.hotel_aynur.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {


	WebDriver driver;
	Properties properties;
	
	public WebDriver initialize_driver(){
		properties=initialize_Properties();
		
		String browser = properties.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("Undefined Browser");
		}
		
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.get(URL);
	driver.get(properties.getProperty("url"));
	return driver;

	}
	
	
	public Properties initialize_Properties(){
		properties=new Properties();
		try {
			FileInputStream inputStream= new FileInputStream("/Users/user/eclipse-workspace"
					+ "/Hotelscom_aynur/src/main/java/com/qa/hotel_aynur/config/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {

		}
		return properties;
		
	}
	
	
}
