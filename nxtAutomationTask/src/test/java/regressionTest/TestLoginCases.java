package regressionTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Products;
import listeners.TestListeners;
import base.Cart;
import base.CommonMethods;
import base.Home;

public class TestLoginCases extends TestListeners {

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
	public void case01_testLoginSuccessfully() {
		home.clickSignUp();
		home.setSignUpUsername("LoginUser" + currentTime);
		home.setSignUpPassword("12345678");
		home.clickSignUpSubmit();
		Assert.assertEquals(cm.checkAlertMsg(), "Sign up successful.");
		cm.acceptAlert();
		Assert.assertFalse(home.isSignUpModalHidden());
		home.clickLogin();
		home.setLoginUsername("LoginUser" + currentTime);
		home.setLoginPassword("12345678");
		home.clickLoginSubmit();
		Assert.assertTrue(home.isWelcomeUsernameDispalyed(null));
	}


	
}
