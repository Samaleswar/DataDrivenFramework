package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.testBase;

public class AddCustomerTest extends testBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String FirstName, String LastName, String PostCode) throws InterruptedException {
		driver.findElement(By.cssSelector(objectRepo.getProperty("addcusBtn"))).click();
		driver.findElement(By.cssSelector(objectRepo.getProperty("firstName"))).sendKeys(FirstName);
		driver.findElement(By.cssSelector(objectRepo.getProperty("lastName"))).sendKeys(LastName);
		driver.findElement(By.cssSelector(objectRepo.getProperty("postCode"))).sendKeys(PostCode);
		driver.findElement(By.cssSelector(objectRepo.getProperty("addBtn"))).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(driver.switchTo().alert().getText().contains("Customer added successfully"));
		driver.switchTo().alert().accept();

	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "AddCustomerTest";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++)

		{

			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}

		}

		return data;

	}
}
