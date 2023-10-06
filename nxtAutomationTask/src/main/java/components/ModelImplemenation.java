package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ModelImplemenation implements Model{

	private WebDriver driver;

	public ModelImplemenation(WebDriver driver) {
		this.driver = driver;
	}

	// div[@class='modal-content']
	public WebElement getElement(String modalId) {
		return driver.findElement(By.xpath("//div[@class='modal-content']/ancestor::div[@id='" + modalId + "']"));
	}

	private WebElement getModalFooter(String modalId) {
		return getElement(modalId).findElement(By.xpath(".//div[contains(@class,'modal-footer')]"));
	}

	private WebElement getModalHeader(String modalId) {
		return getElement(modalId).findElement(By.xpath(".//div[contains(@class,'modal-header')]"));
	}

	public WebElement getModalBody(String modalId) {
		return getElement(modalId).findElement(By.xpath(".//div[contains(@class,'modal-body')]"));
	}

	public WebElement getSelectButton(String moddalId) {
		return getModalFooter(moddalId).findElement(By.xpath(".//button[contains(@class,'btn-primary')]"));
	}

	private WebElement getCloseButton(String moddalId) {
		return getModalFooter(moddalId).findElement(By.xpath(".//button[contains(@class,'btn-secondary')]"));
	}

	public String getTitle(String moddalId) {
		return getModalHeader(moddalId).findElement(By.xpath(".//h5[@class='modal-title']")).getText();
	}

	public void select(String moddalId) {
		getSelectButton(moddalId).click();
	}

	public void close(String moddalId) {
		getCloseButton(moddalId).click();
	}

}
