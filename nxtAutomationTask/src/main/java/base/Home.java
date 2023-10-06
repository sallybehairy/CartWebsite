package base;

import org.openqa.selenium.WebDriver;

import pageobject.HomePage;
import pageobject.ProductsPage;

public class Home {

	HomePage home;
	CommonMethods cm;

	public Home(WebDriver driver) {
		home = new HomePage(driver);
	}

	public void clickSignUp() {
		home.clickSignUp();
	}

	public void clearSignUpUsername() {
		home.clearSignUpUsername();
	}

	public void clearSignUpPassword() {
		home.clearSignUpPassword();
	}

	public void setSignUpUsername(String username) {
		home.setSignUpUsername(username);
	}

	public void setSignUpPassword(String password) {
		home.setSignUpPassword(password);
	}

	public void clickSignUpSubmit() {
		home.clickSignUpSubmit();
	}

	public boolean isSignUpModalHidden() {
		return home.isSignUpModalHidden();
	}

	public void modalClose() {
		home.modalClose();
	}

	// Login Methods
	public void clickLogin() {
		home.clickLogin();
	}

	public void setLoginUsername(String username) {
		home.setLoginUsername(username);
	}

	public void setLoginPassword(String password) {
		home.setLoginPassword(password);
	}

	public void clickLoginSubmit() {
		home.clickLoginSubmit();
	}

	public void loginSuccessfully(String username, String password) {
		home.loginSuccessfully(username, password);
	}

	public boolean isWelcomeUsernameDispalyed(String username) {
		return home.isWelcomeUsernameDispalyed(username);
	}

	public void checkAlertUnsuccessfullLogin(String alertMsg) {
		home.checkAlertUnsuccessfullLogin(alertMsg);
	}

	public void logout() {
		home.logout();

	}

	// Other methods
	public void clickOnPhoneCategory() {
		home.clickOnPhoneCategory();
	}

	public void clickOnLaptopsCategory() {
		home.clickOnLaptopsCategory();
	}

	public void clickOnMonitorsCategory() {
		home.clickOnMonitorsCategory();
	}

	public int getNumberOfItemsListedInCategory() {
		return home.getNumberOfItemsListedInCategory();
	}

	public ProductsPage clickOnItem(String itemName) {
		return home.clickOnItem(itemName);
	}

}
