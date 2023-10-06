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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestListeners implements ITestListener {

	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/src/main/resources/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	@Parameters({ "base.url" })
	public void TestBeforeMethod(String baseurl) {
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void TestAfterMethod(ITestResult testResult) throws IOException {
		// Taking screenshot in case of failure
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".jpg"));
		}
		
		//closing browser session
		driver.quit();
	}

}

