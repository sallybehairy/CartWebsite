package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkipPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public SkipPage(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 10);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "authCode")
	private WebElement authCodeField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//button[contains(text(),'Skip (only for testing)')]")
	private WebElement skipBtn;
	
	public boolean isSkipPageOpen() {
		return skipBtn.isDisplayed();
	}
	
	public MyEventsPage clickSkip() {
		skipBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Events']")));
		return new MyEventsPage(driver);
	}
	
}
