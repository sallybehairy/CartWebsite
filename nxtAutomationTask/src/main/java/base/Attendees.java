package base;

import org.openqa.selenium.WebDriver;

import pageobject.AttendeesPage;

public class Attendees {
	
	AttendeesPage attendessP;
	
	public Attendees(WebDriver driver) {
		attendessP = new AttendeesPage(driver);
	}
	
	public void isLoaded() {
		attendessP.isLoaded();
	}
	
	public void clickAllUsers() {
		attendessP.clickAllUsers();
	}

}
