package base;

import org.openqa.selenium.WebDriver;

import pageobject.DashboardPage;
import pageobject.MyEventsPage;

public class MyEvents {

	MyEventsPage myeventP;
	
	public MyEvents(WebDriver driver) {
		myeventP = new MyEventsPage(driver);
	}
	
	public void isLoaded() {
		myeventP.isLoaded();
	}
	
	public void clickOnEvent(String eventName) {
		myeventP.clickOnEvent(eventName);
	}
	
	public DashboardPage clickOnEvent(int rowIndex) {
		return myeventP.clickOnEvent(rowIndex);
	}
}
