package base;

import org.openqa.selenium.WebDriver;

import pageobject.CartPage;
import pageobject.ProductsPage;

public class Products{
	
	ProductsPage products;
	
	public Products(WebDriver driver) {
		products = new ProductsPage(driver);
	}
	
	public void addToCart() {
		products.addToCart();
	}
	
	public CartPage goToCart() {
		return products.goToCart();
	}
	

}
