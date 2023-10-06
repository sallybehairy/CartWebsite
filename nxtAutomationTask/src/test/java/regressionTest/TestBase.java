package regressionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/src/main/resources/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}

