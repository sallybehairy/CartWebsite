package base;

import org.openqa.selenium.WebDriver;

import pageobject.DashboardPage;

public class Dashboard {

	DashboardPage dashboardP;
	
	public Dashboard(WebDriver driver) {
		dashboardP = new DashboardPage(driver);
	}
	
	public void isLoaded() {
		dashboardP.isLoaded();
	}
	
	public void goToAttendeesPage() {
		dashboardP.goToAttendeesPage();
	}
}
