package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtilities;

public class TC_AddCustomerDDT_001 extends BaseClass{

	@Test(dataProvider="CustomerData")
	public void addCustomerDDT(String cuName, String sexType, String dBirth, String cuAddress, String cuCity, String cuState, String cuPin, String cuMbno, String emailID, String pass ) throws InterruptedException
	{
		String dob=dBirth;
		System.out.println("Date of birth is:"+dob);
		String[] dateofBirth = dBirth.split("-");
		String month=dateofBirth[0];
		String date=dateofBirth[1];
		String year=dateofBirth[2];
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("username is provided:");
		loginPage.setPassword(password);
		logger.info("Password is provided:");
		loginPage.clickLoginButton();
		logger.info("Login button clicked successfully");
		Thread.sleep(3000);
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		try {
			addCustomerPage.clickAddNewCustomer();
			logger.info("Clicked successfully on new customer:");
			addCustomerPage.setCustomerName(cuName);
			logger.info("Customer named passed successfully:");
			addCustomerPage.custGendar(sexType);
			logger.info("Gender selected successfully:");
			addCustomerPage.getDateOfBirth(month,date,year);
			logger.info("Date of birth passed:");
			Thread.sleep(3000);
			addCustomerPage.getAddress(cuAddress);
			logger.info("Address passed successfully:");
			addCustomerPage.getCity(cuCity);
			logger.info("City passed successfully:");
			addCustomerPage.getState(cuState);
			logger.info("State passed successfully:");
			addCustomerPage.getPin(cuPin);
			logger.info("PIN passed successfully:");
			addCustomerPage.getMobileNum(cuMbno);
			logger.info("Mobile No passed successfully:");
			addCustomerPage.getEmailID(emailID);
			logger.info("Email passed successfully:");
			addCustomerPage.getPass(pass);
			logger.info("Password passed successfully:");
			addCustomerPage.clickSubmit();
			logger.info("Clicked on submit");
			Thread.sleep(3000);

			logger.info("Validation started:");
			if(validateCase()==true)
			{
				Assert.assertTrue(true);
				logger.info("Add customer test case has passed:");
			}
			else {
				logger.info("Add customer test case has failed:");
				captureScreenShot(driver, "addCustomerDDT");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateCase()
	{
		boolean flag=driver.getPageSource().contains(addCustomerPageSource);
		return flag;
	}

	@DataProvider(name="CustomerData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerData.xlsx";
		int totalRow=XLUtilities.getRowCount(path);
		int cellCount = XLUtilities.getCellCount(path, totalRow);
		String customerData[][]=new String[totalRow][cellCount];

		for(int i=1; i<=totalRow; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				customerData[i-1][j] = XLUtilities.getCellData(path, i, j); 
			}
		}
		return customerData;
	}

}
