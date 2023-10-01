package regressionTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.AddEditUser;
import base.Attendees;
import base.Dashboard;
import base.Login;
import base.MyEvents;
import base.Skip;
import base.Users;

public class TestCases extends baseTests{

	Login login;
	Skip skipForTesters;
	MyEvents myEvents;
	Dashboard dashboard;
	Attendees attendees;
	Users usersPage;
	AddEditUser addEditUser;
	
	@BeforeClass
	public void TestCasesBeforeClass() {
		login = new Login(driver);
		skipForTesters = new Skip(driver);
		myEvents = new MyEvents(driver);
		dashboard = new Dashboard(driver);
		attendees = new Attendees(driver);
		usersPage = new Users(driver);
		addEditUser = new AddEditUser(driver);
	}
	
	
	@Test
	@Parameters({"username", "password"})
	public void case01_testLoginSuccessfully(String username, String password) {
		login.login(username, password);
		Assert.assertTrue(skipForTesters.isSkipPageOpen());
		skipForTesters.clickSkip();
		myEvents.isLoaded();
	}
	
	@Test
	@Parameters({"username", "password"})
	public void case02_testAddingAttendeeWitATrip(String username, String password) {
		login.login(username, password);
		skipForTesters.clickSkip();
		myEvents.isLoaded();
		myEvents.clickOnEvent("Sally event");
		dashboard.isLoaded();
		attendees.clickAllUsers();
		usersPage.clickAddUser();
		addEditUser.setFirstName("Automation");
		addEditUser.setLastName("User");
		addEditUser.setUsername("AutomationUser1");
		addEditUser.setEmail("automationuser@gmail.com");
		addEditUser.clickSave();
		addEditUser.clickCancel();
		usersPage.clickAddTrip(usersPage.getNumberOfUsers());
		
		
		
		
		
	}
	
}
