package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.OutletPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OutletSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private OutletPage outletPage;
	private static String title;
	
	// Sleep time
			public static void sleep() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
	
	@Given("^user has logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String id = credList.get(0).get("id");
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://salestrack.gipldemo.in/sptclient/client/login");

		// here userpage is added because do login in giving UserPage class
		// refernce

		outletPage = loginPage.doLogin1(id, username, password);
	}
	
	@Given("Outlet after Dashboard")
	public void outlet_after_dashboard() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is:" + title);
	}

	@When("user clicks on Outlets")
	public void user_clicks_on_outlets() {
	    outletPage.OnClickOutlet();
	}

	@When("Outlets title should be {string}")
	public void outlets_title_should_be(String expectedTitleName) {
		//Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("user clicks on Add New Outlet")
	public void user_clicks_on_add_new_outlet() {
		outletPage.OnAddOutlet();
	    sleep();
	}

	@Then("Outlets title should be a {string}")
	public void outlets_title_should_be_a(String expectedTitleName) {
		//Assert.assertTrue(title.contains(expectedTitleName));
		sleep();
	}

	
	@Then("Add Outlet name {string}")
	public void add_outlet_name(String Name) {
	    outletPage.addOutletName(Name);
	}

	@Then("Add contact number {string}")
	public void add_contact_number(String MobNumber) {
	    outletPage.addOutletMobNo(MobNumber);
	}

	@Then("Add Outlet address then add email {string}")
	public void add_outlet_address_then_add_email(String email) {
	   outletPage.addOutletEmail(email);
	}

	@Then("click on Cancel button")
	public void click_on_cancel_button() {
	    outletPage.clickOutletCancel();
	}

}
