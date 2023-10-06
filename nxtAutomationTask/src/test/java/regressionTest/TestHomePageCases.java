package regressionTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Products;
import listeners.TestListeners;
import base.Cart;
import base.CommonMethods;
import base.Home;

public class TestHomePageCases extends TestListeners {

	Home home;
	Cart cart;
	Products products;
	CommonMethods cm;
	long currentTime = System.currentTimeMillis();

	@BeforeClass
	public void TestCasesBeforeClass() {
		home = new Home(driver);
		cart = new Cart(driver);
		products = new Products(driver);
		cm = new CommonMethods(driver);
	}

	@Test(enabled = false)
	public void case01_testRegisterSuccessfully() {
		home.clickSignUp();
		home.setSignUpUsername("AutomationUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Sign up successful.");
		cm.acceptAlert();
		Assert.assertTrue(home.isSignUpModalHidden());
	}

	@Test(enabled = false)
	public void case02_testSignUpWithExistingUser() {
		home.clickSignUp();
		home.setSignUpUsername("AutomationUserExisting" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		cm.acceptAlert();
		home.clickSignUp();
		home.setSignUpUsername("AutomationUserExisting" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "This user already exist.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
		home.closeSignupModal();
	}

	@Test(enabled = false)
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
		home.closeSignupModal();
	}

	@Test(enabled = true)
	public void case04_testLoginSuccessfully() {
		home.clickSignUp();
		home.setSignUpUsername("LoginUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Sign up successful.");
		cm.acceptAlert();
		Assert.assertTrue(home.isSignUpModalHidden());
		home.clickLogin();
		home.setLoginUsername("LoginUser" + currentTime);
		home.setLoginPassword("12345678");
		home.clickLoginSubmit();
		Assert.assertTrue(home.isWelcomeUsernameDispalyed("LoginUser" + currentTime));
	}

	@Test(enabled = false)
	public void case05_testItemsListedInCategories() {
		home.clickSignUp();
		home.setSignUpUsername("ItemsListed" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		cm.acceptAlert();
		home.clickLogin();
		home.setLoginUsername("ItemsListed" + currentTime);
		home.setLoginPassword("12345678");
		home.clickLoginSubmit();
		home.clickOnLaptopsCategory();
		Assert.assertNotEquals(home.getNumberOfItemsListedInCategory(), 0);
		home.clickOnMonitorsCategory();
		Assert.assertNotEquals(home.getNumberOfItemsListedInCategory(), 0);
		home.clickOnPhoneCategory();
		Assert.assertNotEquals(home.getNumberOfItemsListedInCategory(), 0);
	}

}
