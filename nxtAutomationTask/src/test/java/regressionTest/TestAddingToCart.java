package regressionTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Cart;
import base.CommonMethods;
import base.Home;
import base.Products;
import listeners.TestListeners;

public class TestAddingToCart extends TestListeners {
	
	Home home;
	Cart cart;
	Products products;
	CommonMethods cm;
	long currentTime = System.currentTimeMillis();
	String baseURL;

	@BeforeClass
	@Parameters({"base.url"})
	public void TestCasesBeforeClass(String baseurl) {
		home = new Home(driver);
		cart = new Cart(driver);
		products = new Products(driver);
		cm = new CommonMethods(driver);
		home.loginSuccessfully("sallybehairy", "12345678");
		baseURL = baseurl;
	}
	
	//This case isnt testing certain assertion, as I didnt end up being redirected to homepage after clicking ok in sweet alert pop up
	@Test(enabled = false)
	public void case01_testSuccessfullCheckout() {
		home.clickOnLaptopsCategory();
		home.clickOnItem("Sony vaio i5");
		products.addToCart();
		products.goToCart();
		cart.clickPlaceOrderBtn();
		cart.setName("Automation");
		cart.setCountry("Egypt");
		cart.setCity("Cairo");
		cart.setCreditCard("527820009288");
		cart.setMonth("10");
		cart.setYear("2025");
		cart.clickPurchase();
		cart.clickOkAfterPurchasePopUp();
	}
	
	@Test(enabled = false)
	public void case02_testDeletingItemFromCart() throws InterruptedException {
		driver.get(baseURL);
		home.clickOnLaptopsCategory();
		home.clickOnItem("Sony vaio i5");
		products.addToCart();
		products.goToCart();
		Assert.assertEquals(cart.getNumberOfItemInCart(), 1);
		cart.deleteItem(1);
		Assert.assertEquals(cart.getNumberOfItemInCart(), 0);
	}


}
