package stepDefinitions;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private DashboardPage dashboard;
	
	

@Given("Dashboard after login")
public void dashboard_after_login() {
    loginPage.getLoginPageTitle();
}

@Then("bottom line is {string}")
public void bottom_line_is(String bottom) {
    dashboard.getText();
}

}
