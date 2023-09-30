package regressionTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Login;
import base.Skip;

public class TestLoginPage {

	Login login;
	Skip skipForTesters;
	
	@Test
	@Parameters({"username", "password"})
	public void case01_testLoginSuccessfully(String username, String password) {
		login.login(username, password);
		Assert.assertTrue(skipForTesters.isSkipPageOpen());
		skipForTesters.clickSkip();
	}
}
