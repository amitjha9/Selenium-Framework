package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtilities;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pasword) throws IOException
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(uname);
		logger.info("username provided");
		loginPage.setPassword(pasword);
		logger.info("password provided");
		loginPage.clickLoginButton();
		logger.info("Login button clicked");
		
		if(checkAlert()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("login Test case failed");
		}
		else {
			Assert.assertTrue(true);
			loginPage.clickLogoutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login test case passed");
		}
	}
	
	public boolean checkAlert()
	{
		boolean flag=false;
		try {
			driver.switchTo().alert();
			Assert.assertTrue(true);
			flag=true;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int totalRow=XLUtilities.getRowCount(path);
		int cellCount = XLUtilities.getCellCount(path, totalRow);
		String loginData[][]=new String[totalRow][cellCount];
		
		for(int i=1; i<=totalRow; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				loginData[i-1][j] = XLUtilities.getCellData(path, i, j); 
			}
		}
		return loginData;
	}
}
