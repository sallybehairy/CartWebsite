package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver webdriver) {
		driver = webdriver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
	}
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Skip (only for testing)')]")
	private WebElement skipBtn;
	
	public void setUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public SkipPage login(String Username, String Password) {
		setUsername(Username);
		setPassword(Password);
		clickLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Skip (only for testing)')]")));
		return new SkipPage(driver);
	}
	
	public boolean isSkipPageOpen() {
		return skipBtn.isDisplayed();
	}
	
}
