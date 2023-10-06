package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import components.Model;
import components.ModelImplemenation;

import java.util.List;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonMethodsPage cm;
	private String signupModalId = "signInModal";
	private String loginModalId = "logInModal";
	private Model modelPopup;

	public HomePage(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		cm = new CommonMethodsPage(webdriver);
		modelPopup = new ModelImplemenation(webdriver);
	}

	// Sign up
	@FindBy(id = "signin2")
	private WebElement signupBtn;

	// Login
	@FindBy(xpath = "//a[@id='login2']")
	private WebElement loginBtn;

	// Generic
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement signUpLoginClose;
	@FindBy(xpath = "//a[@id='logout2']")
	private WebElement logoutBtn;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Phones']")
	private WebElement phonesCategory;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Laptops']")
	private WebElement laptopsCategory;
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Monitors']")
	private WebElement monitorsCategory;

	// Sign Up Methods
	private WebElement getSignupModal() {
		return driver.findElement(By.id(signupModalId));
	}

	public String getSignupModalHeader() {
		return modelPopup.getTitle(signupModalId);
	}

	public void clickSignUp() {
		signupBtn.click();
		wait.until(ExpectedConditions.visibilityOf(getSignupModal()));
	}

	private WebElement getSignupModalUsernameField() {
		return modelPopup.getModalBody(signupModalId).findElement(By.xpath(".//input[@id='sign-username']"));
	}

	public void clearSignUpUsername() {
		getSignupModalUsernameField().clear();
	}

	public void setSignUpUsername(String username) {
		clearSignUpUsername();
		getSignupModalUsernameField().sendKeys(username);
	}

	private WebElement getSignupModalPasswordField() {
		return modelPopup.getModalBody(signupModalId).findElement(By.xpath(".//input[@id='sign-password']"));
	}

	public void clearSignUpPassword() {
		getSignupModalPasswordField().clear();
	}

	public void setSignUpPassword(String password) {
		clearSignUpPassword();
		getSignupModalPasswordField().sendKeys(password);
	}

	public void clickSignUpSubmit() {
		modelPopup.select(signupModalId);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean isSignUpModalHidden() {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='signInModal']")));
	}

	public void signupModalClose() {
		modelPopup.close(signupModalId);
		wait.until(ExpectedConditions.invisibilityOf(getSignupModal()));
	}

	// Login Methods
	private WebElement getLoginModal() {
		return driver.findElement(By.id(loginModalId));
	}

	public void clickLogin() {
		loginBtn.click();
		wait.until(ExpectedConditions.visibilityOf(getLoginModal()));
	}

	private WebElement getLoginModalUsernameField() {
		return modelPopup.getModalBody(loginModalId).findElement(By.xpath(".//input[@id='loginusername']"));
	}

	public void clearLoginUsername() {
		getLoginModalUsernameField().clear();
	}

	public void setLoginUsername(String username) {
		clearLoginUsername();
		getLoginModalUsernameField().sendKeys(username);
	}

	private WebElement getLoginModalPasswordField() {
		return modelPopup.getModalBody(loginModalId).findElement(By.xpath(".//input[@id='loginpassword']"));
	}

	public void clearLoginPassword() {
		getLoginModalPasswordField().clear();
	}

	public void setLoginPassword(String password) {
		clearLoginPassword();
		getLoginModalPasswordField().sendKeys(password);
	}

	public void clickLoginSubmit() {
		modelPopup.select(loginModalId);
	}

	public void closeLoginModal() {
		modelPopup.close(loginModalId);
	}

	public boolean isLoginModalHidden() {
		return wait.until(ExpectedConditions.invisibilityOf(getLoginModal()));
	}

	public boolean isWelcomeUsernameDispalyed(String username) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser' and text()='Welcome " + username + "']")));
		return driver.findElement(By.xpath("//a[@id='nameofuser' and text()='Welcome " + username + "']"))
				.isDisplayed();
	}
	
	public boolean isWelcomeDisplayed() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser' and contains(text(),'Welcome']")));
		return driver.findElement(By.xpath("//a[@id='nameofuser' and contains(text(),'Welcome']"))
				.isDisplayed();
	}

	public void loginSuccessfully(String username, String password) {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		clickLogin();
		setLoginUsername(username);
		setLoginPassword(password);
		clickLoginSubmit();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser' and text()='Welcome " + username + "']")));
	}

	public void checkAlertUnsuccessfullLogin(String alertMsg) {
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(cm.checkAlertMsg(), alertMsg);
		cm.acceptAlert();
		closeLoginModal();
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
				.findElement(By.xpath("//div[contains(@class,'col-lg-4')]//a[contains(text(),'" + itemName + "')]"));
		item.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@onclick,'addToCart')]")));
		return new ProductsPage(driver);
	}

}
