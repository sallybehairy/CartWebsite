package base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pageobject.CartPage;
import pageobject.HomePage;
import pageobject.ProductsPage;

public class Home {

	HomePage home;
	
	public Home(WebDriver driver) {
		home = new HomePage(driver);
	}
	
	public void clickSignUp() {
		home.clickSignUp();
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

	public void signUpSuccessfully(String username, String password) {
		home.signUp(username, password);
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
