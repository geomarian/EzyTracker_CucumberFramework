package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1.By locators
	private By ACode = By.name("sAuthCode");
	private By UN = By.id("userName");
	private By Pwd = By.id("password");
	
	private By SubmitBtn = By.name("submitBtn");
	
	//2. Create constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	// 3. Page Actions: feature(behaviour) of the page the form of methods
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void enterID(String id){
		driver.findElement(ACode).sendKeys(id);
		 
		 
	}
	public void enterUsername(String username){
		driver.findElement(UN).sendKeys(username);
		 
		 
	}
	public void enterPassword(String password){
		driver.findElement(Pwd).sendKeys(password);
		 
		 
	}
	public void clickOnLogin(){
		driver.findElement(SubmitBtn).click();
	}
	
	
	public DashboardPage hpLogin(String id, String USN, String Pwds) 
	{
		System.out.println("Login with: " + ACode + "username" + USN + "Password is" + Pwds);
		driver.findElement(ACode).sendKeys(id);
		driver.findElement(UN).sendKeys(USN);
		driver.findElement(Pwd).sendKeys(Pwds);
		driver.findElement(SubmitBtn).click();
		// this shows the object of the next landing pagei.e uusers
		return new DashboardPage(driver);
	}
	
	public OutletPage doLogin(String id, String USN, String Pwds) 
	{
		System.out.println("Login with: " + ACode + "username" + USN + "Password is" + Pwds);
		driver.findElement(ACode).sendKeys(id);
		driver.findElement(UN).sendKeys(USN);
		driver.findElement(Pwd).sendKeys(Pwds);
		driver.findElement(SubmitBtn).click();
		// this shows the object of the next landing pagei.e uusers
		return new OutletPage(driver);
	}
	
	public OutletPage doLogin1(String id, String USN, String Pwds) 
	{
		System.out.println("Login with: " + ACode + "username" + USN + "Password is" + Pwds);
		driver.findElement(ACode).sendKeys(id);
		driver.findElement(UN).sendKeys(USN);
		driver.findElement(Pwd).sendKeys(Pwds);
		driver.findElement(SubmitBtn).click();
		// this shows the object of the next landing pagei.e uusers
		return new OutletPage(driver);
	} 
	
	public RoutePageE doLogin2(String id, String USN, String Pwds) 
	{
		System.out.println("Login with: " + ACode + "username" + USN + "Password is" + Pwds);
		driver.findElement(ACode).sendKeys(id);
		driver.findElement(UN).sendKeys(USN);
		driver.findElement(Pwd).sendKeys(Pwds);
		driver.findElement(SubmitBtn).click();
		// this shows the object of the next landing pagei.e uusers
		return new RoutePageE(driver);
	}
	
	public SKUPage doLogin3(String id, String USN, String Pwds) 
	{
		System.out.println("Login with: " + ACode + "username" + USN + "Password is" + Pwds);
		driver.findElement(ACode).sendKeys(id);
		driver.findElement(UN).sendKeys(USN);
		driver.findElement(Pwd).sendKeys(Pwds);
		driver.findElement(SubmitBtn).click();
		// this shows the object of the next landing pagei.e uusers
		return new SKUPage(driver);
	}
}
