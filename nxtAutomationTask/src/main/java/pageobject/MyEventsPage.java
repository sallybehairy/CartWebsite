package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyEventsPage {

private WebDriver driver;
private WebDriverWait wait;
	
	public MyEventsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='My Events']")
	private WebElement myEventsHeader;
	
	
	public DashboardPage clickOnEvent(String eventName) {
		driver.findElement(By.xpath("//div[text()='" + eventName + "']/ancestor::td")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Dashboard']")));
		return new DashboardPage(driver);
	}
	
	public void isLoaded(){
		Assert.assertTrue(driver.getCurrentUrl().contains("/events"));
		Assert.assertTrue(myEventsHeader.isDisplayed());
	}

}
