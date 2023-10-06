package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ModelImplemenation implements Model{

	private WebDriver driver;

	public ModelImplemenation(WebDriver driver) {
		this.driver = driver;
	}

	// div[@class='modal-content']
	public WebElement getElement() {
		return driver.findElement(By.xpath("//div[@class='modal-content']"));
	}

	private WebElement getModalFooter() {
		return getElement().findElement(By.xpath(".//div[contains(@class,'modal-footer')]"));
	}

	private WebElement getModalHeader() {
		return getElement().findElement(By.xpath(".//div[contains(@class,'modal-header')]"));
	}

	public WebElement getModalBody() {
		return getElement().findElement(By.xpath(".//div[contains(@class,'modal-body')]"));
	}

	private WebElement getSelectButton() {
		return getModalFooter().findElement(By.xpath("//button[contains(@class,'btn-primary')]"));
	}

	private WebElement getCloseButton() {
		return getModalFooter().findElement(By.xpath("//button[contains(@class,'btn-secondary')]"));
	}

	public String getTitle() {
		return getModalHeader().findElement(By.xpath(".//h5[@class='modal-title']")).getText();
	}

	public void select() {
		getSelectButton().click();
	}

	public void close() {
		getCloseButton().click();
	}

}
