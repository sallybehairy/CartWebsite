package regressionTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseTests {

	private WebDriver driver;
	
	@BeforeClass
	@Parameters({"base.url"})
	public void setUp(String baseurl) {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}

