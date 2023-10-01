package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AttendeesPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AttendeesPage(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(webdriver, 5);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='All Users']/ancestor::div[@role='button']")
	private WebElement allUsersBtn;
	@FindBy(xpath = "//h2[text()='All Groups']")
	private WebElement allGroupsHeader;
	
	
	public void clickAllUsers() {
		allUsersBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Users']")));
	}
	
	public void isLoaded() {
		Assert.assertTrue(driver.getCurrentUrl().contains("/users/all/groups"));
		Assert.assertTrue(allGroupsHeader.isDisplayed());
		
	}

}
