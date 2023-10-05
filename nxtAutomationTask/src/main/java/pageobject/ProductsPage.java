package pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage{

	private WebDriver driver;
	private WebDriverWait wait;

	public ProductsPage(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(xpath = "//a[contains(@onclick,'addToCart')]")
	private WebElement addToCartBtn;
	@FindBy(xpath = "//a[@href='cart.html']")
	private WebElement cart;

	public void addToCart() {
		addToCartBtn.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "Product added");
		alert.accept();
	}

	public CartPage goToCart() {
		cart.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Products']")));
		return new CartPage(driver);
	}
}
