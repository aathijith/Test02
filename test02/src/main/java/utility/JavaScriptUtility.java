package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtility {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public JavaScriptUtility(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
		this.driver = driver;
	}

	public void scrollDownByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollDownByJS(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+value+")");
	}
}
