package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RoutePageE {
	private WebDriver driver;
	
	public  By clickRoute = By.xpath("//p[contains(text(),'Route')]");
	private By clickAddNewRoute = By.xpath("//a[@title='Add Route' and @class='btn bg-gradient-danger add-btn-header ml-2']");
	private By routeName = By.name("sName");
	private  By selectState = By.xpath("//span[@id='select2-stateDrpDwn-container']");
	private By searchState = By.xpath("//input[@class='select2-search__field' and @tabindex=\"4\"]");
	
	private By selectCity = By.xpath("//input[@class='select2-search__field' and @tabindex=\"4\"]");
	private By selectArea = By.xpath("//input[@class='select2-search__field' and @tabindex=\"5\"]");
	private By clickGetOutlet = By.xpath("//button[@id='get-outlet-btn']");
	private By clickAddRoute = By.xpath("//button[@id='submit-btn']");
	
	// Sleep time
			public static void sleep() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
	public RoutePageE(WebDriver driver) {
		this.driver = driver;
		
	}
	
//	public String getRoutePageTitle() {
//		return driver.getTitle();
//	}
//	
	public  void onClickRoute() {
		driver.findElement(clickRoute).click();
	}
	
	public void onclickAddNewRoute() {
		driver.findElement(clickAddNewRoute).click();
	}
	
	public void fillRouteForm(String rName, String State, String City, String Area) {
		
		
		driver.findElement(routeName).sendKeys(rName);
		sleep();
		//select dropdown
		driver.findElement(selectState).click();
		sleep();
		driver.findElement(searchState).sendKeys(State);
		sleep();
		driver.findElement(searchState).sendKeys(Keys.ARROW_DOWN);
		sleep();
		driver.findElement(searchState).sendKeys(Keys.ENTER);
		
	}
}
