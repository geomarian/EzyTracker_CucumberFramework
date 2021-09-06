package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutletPage {
	public WebDriver driver;
	
	By clickOutlet = By.xpath("//p[contains(text(),'Outlet')]");

	By addOutlet = By.xpath("//a[@title='Add Outlet' and @class='btn bg-gradient-danger add-btn-header ml-2']");
	
	By OutletName = By.name("sOutletName");
	
	By MobNo = By.name("jContactNo");
	
	By userEmail = By.name("sEmail");
	
	By clickCancel = By.xpath("//a[contains(text(),'Cancel')]");
	
	
	public OutletPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getOutletPageTitle(){
		return driver.getTitle();
	}
	
	public void OnClickOutlet(){
		driver.findElement(clickOutlet).click();
	}
	
	public void OnAddOutlet(){
		driver.findElement(addOutlet).click();
	}
	
	public void addOutletName(String Name){
		driver.findElement(OutletName).sendKeys(Name);
	}
	
	public void addOutletMobNo(String MobNumber){
		driver.findElement(MobNo).sendKeys(MobNumber);
	}
	
	public void addOutletEmail(String email){
		driver.findElement(userEmail).sendKeys(email);
	}
	
	public void clickOutletCancel(){
		driver.findElement(clickCancel).click();
	}
	
	
	
	
	
}
