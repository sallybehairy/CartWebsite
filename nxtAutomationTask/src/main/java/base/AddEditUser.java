package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageobject.AddEditUserPage;

public class AddEditUser {
	
	AddEditUserPage addEditUserP;
	
	public AddEditUser(WebDriver driver) {
		addEditUserP = new AddEditUserPage(driver);
	}
	
	public void setFirstName(String name) {
		addEditUserP.setFirstName(name);
	}
	
	public String getFirstName() {
		return addEditUserP.getFirstName();
	}
	
	public void setLastName(String name) {
		addEditUserP.setLastName(name);
	}
	
	public String getLastName() {
		return addEditUserP.getLastName();
	}
	
	public void setEmail(String mail) {
		addEditUserP.setEmail(mail);
	}
	
	public String getEmail() {
		return addEditUserP.getEmail();
	}
	
	public void setUsername(String userName) {
		addEditUserP.setUsername(userName);
	}
	
	public String getUsername() {
		return addEditUserP.getUsername();
	}
	
	public void setPassword(String Password) {
		addEditUserP.setPassword(Password);
	}
	
	public String getPasswordl() {
		return addEditUserP.getPasswordl();
	}
	
	public void clickSave() {
		addEditUserP.clickSave();
	}
	
	public void clickCancel() {
		addEditUserP.clickCancel();
	}
	
	public void clickTripInfo() {
		addEditUserP.clickTripInfo();
	}

}
