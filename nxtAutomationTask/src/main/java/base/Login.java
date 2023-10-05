package base;

import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;

public class Login {

	LoginPage loginp;
	
	public Login(WebDriver driver) {
		loginp = new LoginPage(driver);
	}
	
	public void login(String username, String password) {
		loginp.login(username, password);
	}
	
}
