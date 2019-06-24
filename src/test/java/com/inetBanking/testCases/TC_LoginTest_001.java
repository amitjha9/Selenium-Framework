package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("Entered username");
		loginPage.setPassword(password);
		logger.info("Entered password");
		loginPage.clickLoginButton();

		if(driver.getTitle().equals(pageTitle))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
