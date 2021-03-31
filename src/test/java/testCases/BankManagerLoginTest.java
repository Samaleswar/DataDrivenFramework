package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class BankManagerLoginTest extends testBase {

	@Test
	public void LoginAsBankManager() throws InterruptedException, IOException {
		
		log.debug("Inside Login Test.");
		click("bmlBtn_CSS");
		log.debug("Login Executed.");
		
		driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn_CSS"))).isDisplayed();
		Assert.assertTrue(driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn"))).isDisplayed());
		
		
	}
}
