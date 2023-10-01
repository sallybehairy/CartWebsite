package regressionTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.AddEditUser;
import base.Attendees;
import base.Dashboard;
import base.Login;
import base.MyEvents;
import base.Skip;
import base.Users;

public class TestCases extends baseTests {

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

	@BeforeMethod
	@Parameters({ "base.url" })
	public void TestCasesBeforeMethod(String baseurl) {
		driver.get(baseurl);
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({ "username", "password" })
	public void case01_testLoginSuccessfully(String username, String password) {
		login.login(username, password);
		Assert.assertTrue(skipForTesters.isSkipPageOpen());
		skipForTesters.clickSkip();
		myEvents.isLoaded();
	}

	@Test
	@Parameters({ "username", "password" })
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
		usersPage.clickEditUser("Automation", "User");
		Assert.assertEquals(addEditUser.getFirstName(), "Automation");
		Assert.assertEquals(addEditUser.getLastName(), "User");
		Assert.assertEquals(addEditUser.getUsername(), "AutomationUser1");
		Assert.assertEquals(addEditUser.getEmail(), "automationuser@gmail.com");
		addEditUser.clickCancel();
		usersPage.clickAddTrip("Automation", "User");
		

	}

	@AfterMethod
	public void TakeScreenshot(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}

	}

}
