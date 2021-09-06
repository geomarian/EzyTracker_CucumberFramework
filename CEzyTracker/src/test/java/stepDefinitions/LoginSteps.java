package stepDefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	//title is static so that no need to create object
	private static String title;
	/*
	 * we are not calling any parent-child relation. This is private because,
	 * here Login page already has contructor so Driver (inside will be getting from driver Factory  
	 */
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  
		DriverFactory.getDriver().get("https://salestrack.gipldemo.in/sptclient/client/login");
	
	}
/*
 * In Login.feature file, there are two STEPS of same and are pointed to same as given below method
 */
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		System.out.println("Page title is:" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
			Assert.assertTrue(title.contains(expectedTitleName));
	    
	}


	@When("user enters id {string}")
	public void user_enters_id(String id) {
		loginPage.enterID(id);
	    	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUsername(username);
		
	   	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
		
	   	}
	

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	   	}


}
