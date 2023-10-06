package base;

import org.openqa.selenium.WebDriver;


import pageobject.CartPage;

public class Cart {

	CartPage cart;
	
	public Cart(WebDriver driver) {
		cart = new CartPage(driver);
	}
	
	public int getNumberOfItemInCart() {
		return cart.getNumberOfItemInCart();
	}
	
	public void deleteItem(int itemNumber) throws InterruptedException {
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
