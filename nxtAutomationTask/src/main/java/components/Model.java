package components;

import org.openqa.selenium.WebElement;

public interface Model {

	public WebElement getElement(String modalId);
	public WebElement getModalBody(String moddalId);
	public String getTitle(String moddalId);
	public void select(String moddalId);
	public void close(String moddalId);
	public WebElement getSelectButton(String moddalId);

}