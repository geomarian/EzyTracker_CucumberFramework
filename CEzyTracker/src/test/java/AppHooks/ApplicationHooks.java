package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	/*
	 * Hooks is used to launch browser otherwise, same steps have to write again in feature file
	 * 
	 * We need drivaFactory class has method init_driver that s why we need object of class
	 * 
	 * This is private because webdriver factory and driver these are specific to application hooks & only for this class
	 */
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	//prop refernece has been created & sam will be used below
	Properties prop;
	
	//browser is configured in confi.properties file so we hook with order 0
	@Before(order = 0)
	public void getProperty(){
		configReader = new ConfigReader();
		//prop here will acta as holding parameter/variable
		prop = configReader.init_prop();
		
	}
	
	@Before(order =1)
	public void launchBrowser(){
		//will store in string - variable
		String browserName = prop.getProperty("browser");
		// now creating object of driverfactory
		driverFactory = new DriverFactory();
		
		/*
		 *  and from above we have to call initaliza driver & pass browser name. Prop we have got it in different variable
		 * we need tohave prop.getProperty method so that prop we have to access in diiferent variable
		 */
		
		driver= driverFactory.init_driver(browserName);
		
	}
	
	/*
	 * we have to 
	 */
	@After(order=0)
	public void quitBrowser(){
		/*
		 * Nee to add "driver =" in line 49 because driver in line 59 point to driver line 23 which is null.
		 * so here we can get null pointer exception in line number 59 so we need to add driver =
		 * otherwise null.quit will give nullpointer error
		 */
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			//take screenshot
			
			String screenshotName = scenario.getName().replaceAll("", "_");
		byte [] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
