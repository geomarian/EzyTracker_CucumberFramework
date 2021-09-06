package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.UserPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private UserPage usersPage;
	
	// Sleep time
		public static void sleep() {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}


	@Given("^user has already logged into application")
	public void user_has_already_logged_into_application(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String id = credList.get(0).get("id");
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://salestrack.gipldemo.in/sptclient/client/login");

		// here userpage is added because do login in giving UserPage class
		// refernce

		usersPage = loginPage.doLogin2(id, username, password);
	}

	@Given("user is from Dashboard")
	public void user_is_from_dashboard() {

	}

	@Then("AdminUser gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is:" + title);
		
		
	}

	@And("webpage title should be {string}")
	public void webpage_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));

	}

	@When("user clicks on Users")
	public void user_clicks_on_users() {
		usersPage.clickUserM();
		sleep();
	}

	@And("Userpage title should be {string}")
	public void Userpage_title_should_be(String expectedTitleName) {
		title =usersPage.getUserPageTitle();
		System.out.println("User page title is: " + title);
		Assert.assertTrue(title.contains(expectedTitleName));
		sleep();
	    
	}
	
	@Then("click on refresh button")
	public void click_on_refresh_button(){
		usersPage.clickRefreshM();
		sleep();
	}
	
	
	@Then("user clicks on New user")
	public void user_clicks_on_New_user(){
		usersPage.clickAddUser();
		sleep();
	}
	
	@And("click on cancel button from add user")
	public void click_on_cancel_button_from_add_user(){
		usersPage.getCancelUser();
		sleep();
	}

}
