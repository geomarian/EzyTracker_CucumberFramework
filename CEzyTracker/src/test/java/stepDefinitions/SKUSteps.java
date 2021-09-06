package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.SKUPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SKUSteps {
//	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	private SKUPage skuPage;
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user has logged into application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String id = credList.get(0).get("id");
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://salestrack.gipldemo.in/sptclient/client/login");

		// here userpage is added because do login in giving UserPage class
		// refernce

		skuPage = loginPage.doLogin3(id, username, password);
	}

	@Given("SKU after Dashboard")
	public void sku_after_dashboard() {
		skuPage.getSKUPageTitle();
	}

	@When("user clicks on SKU")
	public void user_clicks_on_sku() {
	    skuPage.OnClickSKU();
	}

	@When("SKU title should be {string}")
	public void sku_title_should_be(String expectedTitleName) {
		//Assert.assertTrue(title.contains(expectedTitleName));

	}

	@Then("user clicks on Add New SKU")
	public void user_clicks_on_add_new_sku() {
	   skuPage.onAddSKU();
	}

	@Then("SKU title should be a {string}")
	public void sku_title_should_be_a(String expectedTitleName) {
	//	Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Add SKU Name {string}")
	public void add_sku_name(String Name) {
	   skuPage.getSKUName(Name);
	}

	@Then("Add Trade Rate {string}")
	public void add_trade_rate(String Rate) {
	    skuPage.getTradeRate(Rate);
	}

	@Then("Add SKU MRP {string}")
	public void add_sku_mrp(String MRP) {
	    skuPage.getMRPRate(MRP);
	}
	
	@Then("click on Cancel SKU")
	public void click_on_cancel_sku() {
	    skuPage.clickSKUCancel();
	}

}
