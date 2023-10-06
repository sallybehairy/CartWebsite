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
	
//	public String checkAlertMsg() {
//		return home.checkAlertMsg();
//	}
//	
//	public void acceptAlert() {
//		home.acceptAlert();
//	}
//	
	public boolean isSignUpModalDisplayed() {
		return home.isSignUpModalDisplayed();
	}


//	public void signUpSuccessfully(String username, String password) {
//		home.signUp(username, password);
//	}
	
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

	public void loginUnsuccessfully(String username, String password) {
		home.loginUnsuccessfully(username, password);

	}

	public void logout() {
		home.logout();

	}

	// Ot
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
