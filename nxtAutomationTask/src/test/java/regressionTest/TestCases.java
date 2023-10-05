package regressionTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Products;
import base.Cart;
import base.Home;

public class TestCases extends TestBase {

	Home home;
	Cart cart;
	Products products;

	@BeforeClass
	public void TestCasesBeforeClass() {
		home = new Home(driver);
		cart = new Cart(driver);
		products = new Products(driver);
	}

	@BeforeMethod
	@Parameters({ "base.url" })
	public void TestCasesBeforeMethod(String baseurl) {
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

	@Test
//	@Parameters({ "username", "password" })
	public void case01_testqpros() {
		home.clickSignUp();
		home.signUpSuccessfully("AutomationUser11", "12345678");
		home.loginSuccessfully("AutomationUser11", "12345678");
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
	public void TestCasesAfterMethod(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
		//closing browser
		driver.quit();

	}

}
