package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageobject.CartPage;

public class Cart {

	CartPage cart;
	
	public Cart(WebDriver driver) {
		cart = new CartPage(driver);
	}
	
	public int getNumberOfItemInCart() {
		return cart.getNumberOfItemInCart();
	}
	
	public void deleteItem(int itemNumber) {
		cart.deleteItem(itemNumber);
	}
	
	public void clickPlaceOrderBtn() {
		cart.clickPlaceOrderBtn();
	}
	
	public String getPlaceOrderModalHeader() {
		return cart.getPlaceOrderModalHeader();
	}
	
	public void setName(String name) {
		cart.setName(name);
	}
	
	public void setCountry(String country) {
		cart.setCountry(country);
	}
	
	public void setCity(String city) {
		cart.setCity(city);
	}
	
	public void setCreditCard(String creditCard) {
		cart.setCreditCard(creditCard);
	}
	
	public void setMonth(String month) {
		cart.setMonth(month);
	}
	
	public void setYear(String year) {
		cart.setYear(year);
	}
	
	public void clickClose() {
		cart.clickClose();
	}
	
	public void clickPurchase() {
		cart.clickPurchase();
	}
	
	public boolean isSuccessfullPurchasePopUpDisplayed() {
		return cart.isSuccessfullPurchasePopUpDisplayed();
	}
	
	public void clickOkAfterPurchasePopUp() {
		cart.clickOkAfterPurchasePopUp();
	}
	
}
