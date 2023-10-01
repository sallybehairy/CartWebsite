package base;

import org.openqa.selenium.WebDriver;
import pageobject.SkipPage;

public class Skip {
	
	SkipPage skipPage;
	
	public Skip(WebDriver driver) {
		skipPage = new SkipPage(driver);
	}
	
	public boolean isSkipPageOpen() {
		return skipPage.isSkipPageOpen();
	}
	
	public void clickSkip() {
		skipPage.clickSkip();
	}

}
