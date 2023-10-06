package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.Alert;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	// Sign up
	@FindBy(id = "signin2")
	private WebElement signupBtn;
	@FindBy(id = "sign-username")
	private WebElement signupUsername;
	@FindBy(id = "sign-password")
	private WebElement signupPassword;
	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signUpSubmit;

	// Login
	@FindBy(id = "login2")
	private WebElement loginBtn;
	@FindBy(id = "loginusername")
	private WebElement loginUsername;
	@FindBy(id = "loginpassword")
	private WebElement loginPassword;
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginSubmit;

	// Generic
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement signUpLoginClose;
	@FindBy(xpath = "//a[@id='logout2'")
	private WebElement logoutBtn;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Phones']")
	private WebElement phonesCategory;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Laptops']")
	private WebElement laptopsCategory;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Monitors']")
	private WebElement monitorsCategory;

	// Sign Up Methods
	public void clickSignUp() {
		signupBtn.click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='signInModal' and @style='display: block;']")));
	}

	public void clearSignUpUsername() {
		signupUsername.clear();
	}

	public void setSignUpUsername(String username) {
		clearSignUpUsername();
		signupUsername.sendKeys(username);
	}

	public void clearSignUpPassword() {
		signupPassword.clear();
	}

	public void setSignUpPassword(String password) {
		clearSignUpPassword();
		signupPassword.sendKeys(password);
	}

	public void clickSignUpSubmit() {
		signUpSubmit.click();
	}

//	public String checkAlertMsg() {
//		Alert alert = driver.switchTo().alert();
//		return alert.getText();
//	}
//	
//	public void acceptAlert() {
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//	}

	public boolean isSignUpModalDisplayed() {
		return driver.findElement(By.xpath("//div[@id='signInModal']")).isDisplayed();
	}

//	public void signUp(String username, String password) {
//		clickSignUp();
//		setSignUpUsername(username);
//		setSignUpPassword(password);
//		signUpSubmit.click();
//		Assert.assertEquals(checkAlertMsg(), "Sign up successful.");
//		acceptAlert();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='signInModal']")));
//	}

	public void modalClose() {
		signUpLoginClose.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='signInModal']")));
	}

	// Login Methods
	public void clickLogin() {
		loginBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='logInModal']")));
	}

	public void setLoginUsername(String username) {
		loginUsername.clear();
		loginUsername.sendKeys(username);
	}

	public void setLoginPassword(String password) {
		loginPassword.clear();
		loginPassword.sendKeys(password);
	}

	public void clickLoginSubmit() {
		loginSubmit.click();
	}

	public void loginSuccessfully(String username, String password) {
		if (logoutBtn.isDisplayed()) {
			logout();
		} else {
			clickLogin();
			setLoginUsername(username);
			setLoginPassword(password);
			loginSubmit.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[@id='nameofuser' and text()='Welcome '" + username + "']]")));
		}

	}

	public void loginUnsuccessfully(String username, String password) {
		clickLogin();
		setLoginUsername(username);
		setLoginPassword(password);
		loginSubmit.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Wrong password.");
		alert.accept();
		signUpLoginClose.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='logInModal']")));

	}

	public void logout() {
		logoutBtn.click();
		wait.until(ExpectedConditions.visibilityOf(loginBtn));

	}

	// Other methods
	public void clickOnPhoneCategory() {
		phonesCategory.click();
	}

	public void clickOnLaptopsCategory() {
		laptopsCategory.click();
	}

	public void clickOnMonitorsCategory() {
		monitorsCategory.click();
	}

	public int getNumberOfItemsListedInCategory() {
		List<WebElement> itemsList = driver
				.findElements(By.xpath("//div[@id='tbodyid']//div[contains(@class,'col-lg-4')]"));
		return itemsList.size();
	}

	public ProductsPage clickOnItem(String itemName) {
		WebElement item = driver
				.findElement(By.xpath("//div[contains(@class,'col-lg-4')][9]//a[contains(text(),'" + itemName + "')]"));
		item.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@onclick,'addToCart')]")));
		return new ProductsPage(driver);
	}

}
