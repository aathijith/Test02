package Base;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.DriverFactory;
import page.LoginPage;


public class BaseTest {
	WebDriver driver;
	protected DriverFactory df;
	protected LoginPage loginPage;
	protected Properties prop;
	
	
	@BeforeTest
	public void setup() {
	 df = new DriverFactory();
	 prop=df.initProp();
	 driver=df.initBrowser(prop);
	 loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
