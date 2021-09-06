package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {

	public WebDriver driver;
	
	By clickUser = By.xpath("//p[contains(text(),'User')]");
	By clickRefresh = By.xpath("//a[@title='refresh' and @class=' btn btn-warning  add-btn-header']");
	By addUser = By.xpath("//a[@title='Add User' and @class='btn bg-gradient-danger add-btn-header ml-2'] ");
	
	By cancelUser = By.xpath("//a[contains(text(),'Cancel')]");
	
	public UserPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getUserPageTitle(){
		return driver.getTitle();
	}
	
	public void clickUserM(){
		driver.findElement(clickUser).click();
	}
	
	public void clickRefreshM(){
		driver.findElement(clickRefresh).click();
	}
	
	public void clickAddUser(){
		driver.findElement(addUser).click();
	}
	
	public void getCancelUser(){
		driver.findElement(cancelUser).click();
	}
	
}
