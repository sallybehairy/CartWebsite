package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripInfoPageInAddEditUser {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public TripInfoPageInAddEditUser(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 5);
		PageFactory.initElements(driver, this);
	}
	
	
}
