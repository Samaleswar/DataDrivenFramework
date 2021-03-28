package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.testBase;

public class LoginTest extends testBase {

		@Test
	public void LoginAsBankManager() throws InterruptedException {
	driver.findElement(By.cssSelector(objectRepo.getProperty("bmlBtn"))).click();
	Thread.sleep(5000);
	}
}
