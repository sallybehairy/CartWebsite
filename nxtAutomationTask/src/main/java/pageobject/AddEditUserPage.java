package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEditUserPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public AddEditUserPage(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement saveBtn;
	@FindBy(xpath = "//p[text()='Trip Info']")
	private WebElement tripInfo;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelBtn;
	
	
	public void setFirstName(String name) {
		firstName.sendKeys(name);
	}
	
	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	
	public void setLastName(String name) {
		lastName.sendKeys(name);
	}
	
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public String getEmail() {
		return email.getAttribute("value");
	}
	
	public void setUsername(String userName) {
		username.sendKeys(userName);
	}
	
	public String getUsername() {
		return username.getAttribute("value");
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public String getPasswordl() {
		return password.getAttribute("value");
	}
	
	public void clickSave() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[text()='Trip Info']")));
	}
	
	public void clickCancel() {
		cancelBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Users']")));
	}
	
	public void clickTripInfo() {
		tripInfo.click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='Invitation Type']")));
	}
	
	
	
	
	
}

