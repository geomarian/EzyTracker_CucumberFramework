package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.LoginPage;
import com.pages.RoutePageE;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RouteStepsE {

	private  RoutePageE routesPages;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	
	
	// Sleep time
	public static void sleep() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
	}
			
	@Given("user has logged application")
	public void user_has_logged_application(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String id = credList.get(0).get("id");
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://salestrack.gipldemo.in/sptclient/client/login");

		// here userpage is added because do login in giving UserPage class
		// refernce

		routesPages = loginPage.doLogin2(id, username, password);
	}

	@When("user clicks on Get Routes button")
	public void user_clicks_on_get_outlets_button() {
		routesPages.onClickRoute();
		sleep();
	}

	@Then("user clicks on Add button")
	public void user_clicks_on_add_button() {
		routesPages.onclickAddNewRoute();
	}
	
	@Then("User fills the data from given sheetName {string} and rowNumber {int}")
	public void user_fills_the_data_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	 
		
		 
		 
		ExcelReader reader = new ExcelReader();
	   List<Map<String,String>> testData = reader.getData("E:/GEO/seleniumCucumber.xlsx", sheetName);
	   String setrName= testData.get(rowNumber).get("RouteName");
	   String setState= testData.get(rowNumber).get("State");
	   String setCity= testData.get(rowNumber).get("City");
	   String setArea= testData.get(rowNumber).get("Area");
	
	   routesPages.fillRouteForm(setrName, setState, setCity, setArea);
	}
	
	
	



	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String string) {
	   
	}

}
