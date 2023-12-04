package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import constants.AppConstants;

public class DriverFactory {

	private WebDriver driver;
	private Properties prop;

	public WebDriver initBrowser(Properties prop) {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		else System.out.println("Pass the correct browser name...");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	public Properties initProp() {
		Properties prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream(".\\src\\test\\java\\Config\\config.properties");
			try {
				prop.load(fip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	public File takeSS() throws IOException {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File file=ts.getScreenshotAs(OutputType.FILE);
		 //File file=new File("");
		 FileUtils.copyFile(file, new File("C:\\\\Users\\\\amrut\\\\eclipse-workspace\\\\test02\\\\screenshot/"+System.currentTimeMillis()+".png"));
		 return file;
		
	}
	


	
}
