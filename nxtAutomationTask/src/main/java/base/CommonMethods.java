package base;

import org.openqa.selenium.WebDriver;

import pageobject.CommonMethodsPage;

public class CommonMethods {
	
	CommonMethodsPage cm;

	public CommonMethods(WebDriver webdriver) {
		cm = new CommonMethodsPage(webdriver);
	}

	public String checkAlertMsg() {
		return cm.checkAlertMsg();
	}
	
	public void acceptAlert() {
		cm.acceptAlert();
	}
	
	
}
