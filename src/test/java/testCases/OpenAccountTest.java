package testCases;

import org.testng.annotations.Test;

import com.mysql.cj.core.util.TestUtils;

import base.testBase;

public class OpenAccountTest extends testBase {

	@Test(dataProviderClass=TestUtils.class,dataProvider = "getData")
	public void openAccountTest(String Customer,String Currency) throws InterruptedException {
	
		
		
		
	}

	}
