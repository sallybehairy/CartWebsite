package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {

	private WebDriver driver;
	private WebDriverWait wait;
		
		public DashboardPage(WebDriver webdriver) {
			driver = webdriver;
			wait = new WebDriverWait(driver, 10);
	        PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//span[text()='Registration']")
		private WebElement registeration;	
		@FindBy(xpath = "//a[@href='/users']")
		private WebElement attendees;
		@FindBy(xpath = "//h2[text()='Dashboard']")
		private WebElement dashboardHeader;
		
		public void goToAttendeesPage() {
			registeration.click();
			wait.until(ExpectedConditions.visibilityOf(attendees));
			attendees.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='All Groups']")));
		}
		
		public void isLoaded() {
			Assert.assertTrue(dashboardHeader.isDisplayed());
		}
		
}
