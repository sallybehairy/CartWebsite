package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public UsersPage(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 10);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/users/new']")
	private WebElement addUser;
	@FindBy(xpath = "//h2[text()='User Details']")
	private WebElement addEditUserHeader;
	
	
	public void clickAddUser() {
		addUser.click();
		wait.until(ExpectedConditions.visibilityOf(addEditUserHeader));
	}
	
	
	//fragile implementation, since the firstName and lastName are not unique across users listing page
	//the xpath for addtripbutton shall only work if no trips were added at all for this user
	public void clickAddTrip(String firstName, String lastName) {
		driver.findElement(By.xpath("//span[text()='" + firstName + "' and text()=' " + lastName + "']/ancestor::tr//td[@id='col-4']//button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='User Trip']")));
	}
	
	public int getNumberOfUsers() {
		return driver.findElements(By.xpath("//tbody//tr")).size();
	}
	
	public void clickEditUser(String firstName, String lastName) {
		driver.findElement(By.xpath("//span[text()='" + firstName + "' and text()=' " + lastName + "']/ancestor::tr//td[@id='col-5']//button")).click();
		wait.until(ExpectedConditions.visibilityOf(addEditUserHeader));
	}
}
