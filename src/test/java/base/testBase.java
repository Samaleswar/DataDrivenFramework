package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testBase {
	
	
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties objectRepo=new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	@BeforeSuite
	public void setUp() throws IOException {
		
		if(driver==null) {
			
			String filePath = System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
			fis=new FileInputStream(filePath);
			config.load(fis);
			
			String filePath1 = System.getProperty("user.dir")+"/src/test/resources/properties/objectRepo.properties";
			fis1=new FileInputStream(filePath1);
			objectRepo.load(fis1);
		
			
			if(config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe"); 
				driver = new ChromeDriver(); 		
			}
			else if(config.getProperty("browser").equals("firefox"))
			{

				System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe"); 
				driver = new FirefoxDriver();

			}
			
			driver.get(config.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	
			}
			
			
			
			
		}
		
	
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}
}
