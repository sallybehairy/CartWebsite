package regressionTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.CommonMethods;
import base.Home;

public class TestSignUpCases extends TestBase {

	Home home;
	CommonMethods cm;
	long currentTime = System.currentTimeMillis();

	@BeforeClass
	public void TestSignupBeforeClass() {
		home = new Home(driver);
		cm = new CommonMethods(driver);
	}

	@BeforeMethod
	@Parameters({ "base.url" })
	public void TestSignupBeforeMethod(String baseurl) {
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void case01_testRegisterSuccessfully() {
		home.clickSignUp();
		home.setSignUpUsername("AutomationUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Sign up successful.");
		cm.acceptAlert();
		Assert.assertTrue(home.isSignUpModalHidden());
	}
	
	@Test
	public void case02_testSignUpWithExistingUser() {
		home.clickSignUp();
		home.setSignUpUsername("AutomationUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "This user already exist.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
	}
	
	@Test
	public void case03_testSignUpValidations() {
		home.clickSignUp();
		home.clearSignUpUsername();
		home.clearSignUpPassword();
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Please fill out Username and Password.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Please fill out Username and Password.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
		home.clearSignUpPassword();
		home.setSignUpUsername("AutomationUser1" + currentTime);
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Please fill out Username and Password.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
		home.modalClose();
	}

//	@Test
//	public void case01_testqpros() {
//		home.loginSuccessfully("AutomationUser11", "12345678");
//		home.clickOnLaptopsCategory();
//		home.clickOnItem("Sony vaio i5");
//		products.addToCart();
//		products.goToCart();
//		cart.clickPlaceOrderBtn();
//		cart.setName("Sally");
//		cart.setCreditCard("123");
//		cart.clickPurchase();
//		cart.clickOkAfterPurchasePopUp();
//	}
	
	@AfterMethod
	public void TestSignupAfterMethod(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}

	}

}
