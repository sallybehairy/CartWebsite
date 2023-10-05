package base;

import org.openqa.selenium.WebDriver;

import pageobject.UsersPage;

public class Users {
	UsersPage usersP;
	
	public Users(WebDriver driver) {
		usersP = new UsersPage(driver);
	}
	
	public void clickAddUser() {
		usersP.clickAddUser();
	}
	
	public void clickAddTrip(String firstName, String lastName) {
		usersP.clickAddTrip(firstName, lastName);
	}
	
	public int getNumberOfUsers() {
		return usersP.getNumberOfUsers();
	}
	
	public void clickEditUser(String firstName, String lastName) {
		usersP.clickEditUser(firstName, lastName);
	}

}
