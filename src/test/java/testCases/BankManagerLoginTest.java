package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

public class BankManagerLoginTest extends testBase {

	@Test
	public void loginAsBankManager() throws InterruptedException, IOException {
		log.debug("Inside Login Test.");
		click("bmlBtn_CSS");
		log.debug("Login Executed.");

		Assert.assertTrue(driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn_CSS"))).isDisplayed());

	}

	@Test
	public void bankName() {
		String bankname = driver.findElement(By.cssSelector(objectRepo.getProperty("bankName_CSS"))).getText();

		Assert.assertEquals(bankname, objectRepo.getProperty("actualBankName"));
		log.info("Bank Name Verified.");
	}
}
