package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.Model;
import components.ModelImplemenation;

public class CartPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Model placeOrderModel;
	private Actions act;
	private String modalId = "orderModal";

	public CartPage(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		placeOrderModel = new ModelImplemenation(webdriver);
		act = new Actions(webdriver);
	}

	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	private WebElement placeOrderBtn;

	public int getNumberOfItemInCart() {
		List<WebElement> cartProducts = driver.findElements(By.xpath("//tbody//tr"));
		return cartProducts.size();
	}

	public void clickPlaceOrderBtn() {
		placeOrderBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orderModal']")));
	}

	// I know using thread sleep isnt the best approach here, but Im still trying to
	// figure out a fix
	public void deleteItem(int itemNumber) throws InterruptedException {
		driver.findElement(By.xpath("//tr[" + itemNumber + "]//a[text()='Delete']")).click();
		Thread.sleep(2000);
	}

	// Handling place order model that appear after clicking place order button
	public WebElement getPlaceOrderModal() {
		return driver.findElement(By.id(modalId));
	}

	public String getPlaceOrderModalHeader() {
		return placeOrderModel.getTitle(modalId);
	}

	public void setName(String name) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='name']")).sendKeys(name);
	}

	public void setCountry(String country) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='country']")).sendKeys(country);
	}

	public void setCity(String city) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='city']")).sendKeys(city);
	}

	public void setCreditCard(String creditCard) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='card']")).sendKeys(creditCard);
	}

	public void setMonth(String month) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='month']")).sendKeys(month);
	}

	public void setYear(String year) {
		placeOrderModel.getModalBody(modalId).findElement(By.xpath("//input[@id='year']")).sendKeys(year);
	}

	public void clickClose() {
		placeOrderModel.close(modalId);
	}

	public void clickPurchase() {
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		placeOrderModel.select(modalId);
	}

	public boolean isSuccessfullPurchasePopUpDisplayed() {
		return driver.findElement(By.xpath("//div[contains(@class,'sweet-alert')]")).isDisplayed();
	}

	public void clickOkAfterPurchasePopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sweet-alert')]")));
		driver.findElement(By.xpath("//div[contains(@class,'sweet-alert')]//button[contains(@class,'btn-primary')]"))
				.click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='orderModal']")));
//		wait.until(ExpectedConditions.urlToBe("https://demoblaze.com/index.html"));
	}

}
