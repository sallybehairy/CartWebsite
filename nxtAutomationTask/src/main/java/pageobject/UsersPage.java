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
		wait = new WebDriverWait(webdriver, 5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/users/new']")
	private WebElement addUser;
	
	
	public void clickAddUser() {
		addUser.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='User Details']")));
	}
	
	public void clickAddTrip(int rowIndex) {
		driver.findElement(By.xpath("//tbody//tr[" + rowIndex + "]//span[text()='Add Trip']/ancestor::button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='User Trip']")));
	}
	
	public int getNumberOfUsers() {
		return driver.findElements(By.xpath("//tbody//tr")).size();
	}
}
