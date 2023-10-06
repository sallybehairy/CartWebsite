package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethodsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public CommonMethodsPage(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public String checkAlertMsg() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
}
