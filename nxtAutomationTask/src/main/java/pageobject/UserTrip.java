package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTrip {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public UserTrip(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='User Trip']")
	private WebElement userTripPageHeader;
	@FindBy(xpath = "//h3[text()='Create Companion']")
	private WebElement companionPanelHeader;
	
	
}
