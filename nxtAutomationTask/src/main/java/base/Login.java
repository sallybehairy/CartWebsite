package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.LoginPage;
import pageobject.SkipPage;

public class Login {

	LoginPage loginp;
	SkipPage skipp;
	WebDriverWait wait;
	
	public Login(WebDriver driver) {
		loginp = new LoginPage(driver);
		wait = new WebDriverWait(driver, 5);
	}
	
	public void login(String username, String password) {
		loginp.login(username, password);
	}
	
}
