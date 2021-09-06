package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	//Using thread local to execute in parallel
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/*
	 * This method is used to initialize the thread local driver on the basis of given browser
	 * 
	 */
	
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: " + browser);
		
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
		/*
		 * thread local will give get & set method
		 * when initialize chrome driver, it is set with local driver so that
		 * it will create local driver copy for specific thread. & tlDriver has instance
		 * of <webdriver> above
		 * Due to thread driver, it will get same copy of the driver
		 */
			tlDriver.set(new ChromeDriver());
			
		}
		else if (browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
	}
		else {
			System.out.println("Please pass correct browser" + browser);
		}
		getDriver().manage().deleteAllCookies();
		
		/*
		 * getDriver is returning WebDriver so the return type above changed from void to webdriver
		 * ]
		 * 
		 */
		return getDriver();
}
	
	//get the Driver
	//This is used to get the driver with threadlocal & synch. in used in parallel execution
	
	public static synchronized WebDriver getDriver(){
		/*
		 * When call getDriver it will return thread local instance
		 * where Threadlocal instance where it is initialize above with new chrome or ff driver
		 * as we are passing WebElement in generic
		 * 
		 * 
		 * Instead of void we have to write WebDriver becuase get method is giving webdriver because of get method
		 * as it local is initalize in webdriver as generic
		 */
	return	tlDriver.get();
		
	}
}
