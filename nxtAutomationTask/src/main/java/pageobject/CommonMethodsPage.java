package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean isAlertPresent() {
		return wait.until(ExpectedConditions.alertIsPresent()) != null;
	}
	
	
}
