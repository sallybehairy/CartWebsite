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

import base.Products;
import base.Cart;
import base.CommonMethods;
import base.Home;

public class TestLoginCases extends TestBase {

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

	@BeforeMethod
	@Parameters({ "base.url" })
	public void TestLoginBeforeMethod(String baseurl) {
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@Test
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

	@Test
	public void case01_testqpros() {
		home.loginSuccessfully("sallybehairy", "12345678");
		home.clickOnLaptopsCategory();
		home.clickOnItem("Sony vaio i5");
		products.addToCart();
		products.goToCart();
		cart.clickPlaceOrderBtn();
		cart.setName("Sally");
		cart.setCreditCard("123");
		cart.clickPurchase();
		cart.clickOkAfterPurchasePopUp();
	}
	
	@AfterMethod
	public void TestLoginAfterMethod(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
	}
}
