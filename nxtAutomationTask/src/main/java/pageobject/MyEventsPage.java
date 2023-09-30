package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyEventsPage {

WebDriver driver;
WebDriverWait wait;
	
	public MyEventsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[text()='My Events']")
	private WebElement myEventsHeader;
	
	
	public void clickOnEvent(String eventName) {
		driver.findElement(By.xpath("//div[text()='" + eventName + "']/ancestor::td")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(eventName)));
	}
}
