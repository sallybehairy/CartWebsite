package listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
	private static String FILE_PATH = "src/main/resources";
	private Properties properties;
	
	private void loadConfigProperties() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream( FILE_PATH + File.separator + "config.properties");
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TestListeners() {
		loadConfigProperties();
	}

	@BeforeClass
	@Parameters({ "base.url" })
	public void setUp(String baseurl) {
		String driverPath = properties.getProperty("chromedriver.path");
		System.setProperty("webdriver.chrome.driver", driverPath);
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
		try {
			if (testResult.getStatus() == ITestResult.FAILURE) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile,
						new File(properties.getProperty("screenshot.directory") + testResult.getName() + ".jpg"));
			}
		} catch (IOException e) {
			System.out.println("Failed to capture or save screenshot: " + e.getMessage());
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
