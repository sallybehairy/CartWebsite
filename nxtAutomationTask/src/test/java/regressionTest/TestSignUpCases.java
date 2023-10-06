package regressionTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
		home.setSignUpUsername("AutomationUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "This user already exist.");
		cm.acceptAlert();
		Assert.assertTrue(home.isSignUpModalHidden());
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
		home.modalClose();
	}

}
