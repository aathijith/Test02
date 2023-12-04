package page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.AppConstants;
import utility.ElementUtil;
import utility.JavaScriptUtility;

public class LoginPage {
	
	WebDriver driver;
	ElementUtil eleUtil;
	JavaScriptUtility jsUtil;
	Properties prop;
	//private By headerLink=By.xpath("//div[@class='navigation']//a");
	private By header1=By.xpath("//*[@id=\"content\"]/div/h4");
	private By header2=By.xpath("//*[@id=\"content\"]/div/h2");
	private By paragraph=By.xpath("//div[@class='explanation']");
	private By formauth=By.xpath("//*[@id=\"content\"]/ul/li[21]/a");
	private By username=By.xpath("//*[@id=\"username\"]");
	private By password=By.xpath("//*[@id=\"password\"]");
	private By login=By.xpath("//*[@id=\"login\"]/button");
	private By logout=By.xpath("//*[@id=\"content\"]/div/a/i");
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		 eleUtil = new ElementUtil(driver);
		 jsUtil=new JavaScriptUtility(driver);
	}
	
	public String getTitle() {
		//return eleUtil.getTitle();
		return driver.getTitle();
	}
	
	public String getheaderText1() {
		String headerText = eleUtil.getElement(header1).getText();
		return headerText;
	}
	public String getheaderText2() {
		String headerText = eleUtil.getElement(header2).getText();
		return headerText;
	}
	
	public String getParaText() {
		String paraText = eleUtil.getElement(paragraph).getText();
		return paraText;
	}
	
//	public boolean getWebPageLInk() {
//		eleUtil.waitForElementVisibility(formauth, AppConstants.HIGH_WAIT);
//		boolean webPageLink = eleUtil.getElement(formauth).isDisplayed();
//		return webPageLink;
//		
//	}
	
	public String getTitleValue() {
		return eleUtil.getTitle();
	}
	
	public void getLogin() throws InterruptedException {
		eleUtil.waitForElementPresence(formauth, AppConstants.LOW_WAIT);
		eleUtil.doClick(formauth);
		sleep(3000);
		eleUtil.doSendKeys(username,"tomsmith");
		eleUtil.doSendKeys(password,"SuperSecretPassword!");
		sleep(3000);
		eleUtil.doClick(login);
		eleUtil.waitForElementVisibility(logout, AppConstants.HIGH_WAIT);
		sleep(3000);
		eleUtil.doClick(logout);
		sleep(3000);
		
	}
	
	public void sleep(long m) {
		try {
			Thread.sleep(m);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
	
	

