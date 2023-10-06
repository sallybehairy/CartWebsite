package regressionTest;

import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void TestCasesBeforeClass() {
		home = new Home(driver);
		cart = new Cart(driver);
		products = new Products(driver);
		cm = new CommonMethods(driver);
	}
	
	
	@Test(enabled = true)
	public void case01_testqpros() {
		home.loginSuccessfully("sallybehairy", "12345678");
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

}
