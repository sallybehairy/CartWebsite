package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkipPage {

	WebDriver driver;
	
	public SkipPage(WebDriver driver) {
		this.driver = driver;
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
	
	public void clickSkip() {
		skipBtn.click();
	}
	
}
