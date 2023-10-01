package regressionTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseTests {

	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}

