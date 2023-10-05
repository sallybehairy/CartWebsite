package components;

import org.openqa.selenium.WebElement;

public interface Model {

	public WebElement getElement();
	public WebElement getModalBody();
	public String getTitle();
	public void select();
	public void close();

}