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
	
	public void clickAddTrip(int rowIndex) {
		usersP.clickAddTrip(rowIndex);
	}
	
	public int getNumberOfUsers() {
		return usersP.getNumberOfUsers();
	}

}
