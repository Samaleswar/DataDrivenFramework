package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.core.util.TestUtils;

import base.testBase;

public class AddCustomerTest extends testBase {

	@Test(dataProviderClass = utilities.TestUtils.class, dataProvider = "getData")
	public void addCustomerTest(String FirstName, String LastName, String PostCode) throws InterruptedException {
		click("addcusBtn_CSS");
		type("firstName_CSS", FirstName);
		type("lastName_CSS", LastName);
		type("postCode_CSS", PostCode);
		click("addBtn_CSS");
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
		driver.switchTo().alert().accept();

	}

}
