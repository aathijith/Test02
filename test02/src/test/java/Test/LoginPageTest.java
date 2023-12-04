package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import constants.AppConstants;
import page.LoginPage;
import utility.ElementUtil;

public class LoginPageTest extends BaseTest {
	
	

//	
//	@Test
//	public void titleTest() {
//		Assert.assertEquals(loginPage.getTitle(), AppConstants.LOGINPAGE_TITLE_VALUE);
//	}
//	@Test
//	public void paraTest() throws IOException {
//		
//		String para=loginPage.getParaText();
//		df.takeSS();
//		Assert.assertEquals(true,para.contains("Automation, Software Testing, Web Automating"));
//		
//	}
	
	@Test(priority=1)
public void logTest() throws InterruptedException {
		loginPage.getLogin();
	}
	
	@Test(priority=2)
	public void paraTest() {
		String header1=loginPage.getheaderText1();
		//Assert.assertTrue(header.contains("Practice Applications and Pages For Automating and Testing"));
		Assert.assertEquals(header1, "Welcome to the Secure Area. When you are done click logout below.");
		try {
			df.takeSS();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=3)
	public void headerTest() {
		String header2=loginPage.getheaderText2();
		
		Assert.assertEquals(header2,"Login Page");
		
		try {
			df.takeSS();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
