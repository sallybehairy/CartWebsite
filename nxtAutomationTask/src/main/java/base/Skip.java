package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.SkipPage;

public class Skip {
	
	SkipPage skipPage;
	WebDriverWait wait;
	
	public Skip(WebDriver driver) {
		skipPage = new SkipPage(driver);
		wait = new WebDriverWait(driver, 5);
	}
	
	public boolean isSkipPageOpen() {
		return skipPage.isSkipPageOpen();
	}
	
	public void clickSkip() {
		skipPage.clickSkip();
	}

}
