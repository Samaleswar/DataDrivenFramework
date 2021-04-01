package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.core.util.TestUtils;

import base.testBase;

public class OpenAccountTest extends testBase {

	@Test(dataProviderClass = utilities.TestUtils.class, dataProvider = "dp")
	public void openAccountTest(String Customer, String Currency) throws InterruptedException {

		click("openAccount_CSS");
		click("customer_css");
		selectFromDropdown("customer_CSS", Customer);
		selectFromDropdown("currency_CSS", Currency);

		click("processBtn_XPATH");
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Account created successfully"));
		driver.switchTo().alert().accept();

	}

}
