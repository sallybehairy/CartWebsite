package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestListeners implements ITestListener {

	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({ "base.url" })
	public void setUp(String baseurl) {
		System.setProperty("webdriver.chrome.driver","D:\\SALLY\\newqpros\\CartWebsite\\nxtAutomationTask\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	@Parameters({ "base.url" })
	public void beforeMethod(String baseurl) {
		driver.get(baseurl);
	}
	
	
	@AfterMethod
	public void TestAfterMethod(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + ".jpg"));
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

