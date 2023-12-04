package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public void doSendKeys(By locator,String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}
	
	public void waitForElementPresence(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void waitForElementVisibility(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	
	//***********8Actions ************;
	public void doActionClick(By locator) {
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(locator);
		actions.click(ele).build().perform();
	}
	
	public void doMouseHover(By locator) {
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(locator);
		actions.moveToElement(ele).build().perform();
	}
	
	


}
