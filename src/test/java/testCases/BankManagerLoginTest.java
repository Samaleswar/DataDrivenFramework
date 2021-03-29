package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class BankManagerLoginTest extends testBase {

	@Test
	public void LoginAsBankManager() throws InterruptedException {

		log.debug("Inside Login Test.");
		driver.findElement(By.cssSelector(objectRepo.getProperty("bmlBtn"))).click();
		Thread.sleep(5000);
		log.debug("Login Executed.");
		driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn"))).isDisplayed();
		Assert.assertTrue(driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn"))).isDisplayed());
		
		
	}
}
