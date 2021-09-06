package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	

	public WebDriver driver;
	By header = By.xpath("//strong[contains(text(),'Copyright © 2021 Sales Person Tracking')]");

	
	public DashboardPage(WebDriver driver){
		this.driver=driver;
	}


	public String getDashboardTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public void getText() {
		driver.findElement(header);
	}
	
	
	}
	

