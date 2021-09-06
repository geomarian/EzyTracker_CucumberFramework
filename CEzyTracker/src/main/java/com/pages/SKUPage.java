package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SKUPage {

	public WebDriver driver;
	By clickSKU = By.xpath("//p[contains(text(),'SKU')]");
	By addSKU = By.xpath("//a[@title='Add SKU' and @class='btn bg-gradient-danger add-btn-header ml-2']");
	By skuName = By.name("sName");
	By tradeRate = By.name("fTradeRate");
	By MRPRate = By.name("fMrp");
	By clickCancel = By.xpath("//a[contains(text(),'Cancel')]");
	
	public SKUPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getSKUPageTitle(){
		return driver.getTitle();
	}
	
	public void OnClickSKU(){
		driver.findElement(clickSKU).click();
	}
	
	public void onAddSKU() {
		driver.findElement(addSKU).click();
	}
	
	public void getSKUName(String Name) {
		driver.findElement(skuName).sendKeys(Name);
	}
	
	public void getTradeRate(String Rate) {
		driver.findElement(tradeRate).sendKeys(Rate);
	}
	
	public void getMRPRate(String MRP) {
		driver.findElement(MRPRate).sendKeys(MRP);
		
	}
	
	public void clickSKUCancel(){
		driver.findElement(clickCancel).click();
	}
}
