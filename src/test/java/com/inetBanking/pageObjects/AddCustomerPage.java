package com.inetBanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}

	//inspect the every element by their xpath
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement addNewCustomer;

	@FindBy(xpath="//input[@type='text' and @name='name']")
	@CacheLookup
	WebElement customerName;

	@FindBy(xpath="//input[@type='radio' and @name='rad1']")
	@CacheLookup
	WebElement gender;

	@FindBy(xpath="//input[@type='radio' and @name='rad1' and @value='m']")
	@CacheLookup
	WebElement maleRadioButton;

	@FindBy(xpath="//input[@type='radio' and @name='rad1' and @value='f']")
	@CacheLookup
	WebElement femaleRadioButton;

	@FindBy(xpath="//input[@type='date' and @name='dob']")
	@CacheLookup
	WebElement dateOfBirth;

	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement pin;

	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement mobileNumber;

	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="//input[@type='submit' and @name='sub']")
	@CacheLookup
	WebElement submit;

	@FindBy(xpath="//input[@type='reset' and @name='res']")
	@CacheLookup
	WebElement reset;

	//Action method for the web element present on the Add customer page
	public void clickAddNewCustomer()
	{
		try {
			addNewCustomer.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void setCustomerName(String custName)
	{
		try {
			customerName.sendKeys(custName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void custGendar(String genderType)
	{
		try {
			String maleValue=maleRadioButton.getText();
			String  femaleValue = femaleRadioButton.getText();
			if(genderType.equals(maleValue))
			{
				maleRadioButton.click();
			}
			else if (genderType.equals(femaleValue)) {
				femaleRadioButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDateOfBirth(String mm, String dd, String yy)
	{
		try {
			dateOfBirth.sendKeys(mm);
			dateOfBirth.sendKeys(dd);
			dateOfBirth.sendKeys(yy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAddress(String addres)
	{
		try {
			address.sendKeys(addres);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCity(String cityName)
	{
		try {
			city.sendKeys(cityName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getState(String stateName)
	{
		try {
			state.sendKeys(stateName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPin(String pinNum)
	{
		try {
			pin.sendKeys(String.valueOf(pinNum));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getMobileNum(String contactNum)
	{
		try {
			mobileNumber.sendKeys(contactNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getEmailID(String emailid)
	{
		try {
			email.sendKeys(emailid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getPass(String passwd)
	{
		try {
			password.sendKeys(passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSubmit()
	{
		try {
			submit.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickReset()
	{
		try {
			reset.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
