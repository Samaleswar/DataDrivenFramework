package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listeners.CustomListeners;
import utilities.ExcelReader;

public class testBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties objectRepo = new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() throws IOException {

		if (driver == null) {

			String filePath = System.getProperty("user.dir") + "/src/test/resources/properties/config.properties";
			fis = new FileInputStream(filePath);
			config.load(fis);
			log.debug("Config file loaded.");

			String filePath1 = System.getProperty("user.dir") + "/src/test/resources/properties/objectRepo.properties";
			fis1 = new FileInputStream(filePath1);
			objectRepo.load(fis1);

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Lunched.");

			} else if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox Lunched");

			}

			driver.get(config.getProperty("testurl"));
			log.debug("Nevigated to the TestUrl :" + config.getProperty("testurl"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait=new WebDriverWait(driver,5);

		}

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {

			driver.quit();
		}
		log.debug("Test Completed and Browser is Closed.");

	}
	
	
	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(objectRepo.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(objectRepo.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(objectRepo.getProperty(locator))).click();
		}
		CustomListeners.extentTest.get().log(Status.INFO, "Clicking on :"+locator);
}
	
	public void type(String locator,String value) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(objectRepo.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(objectRepo.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(objectRepo.getProperty(locator))).sendKeys(value);
		}
		CustomListeners.extentTest.get().log(Status.INFO, "Sending Keys To :"+locator+" WithValue :"+value);

	}
	
	
	
	
	
}
