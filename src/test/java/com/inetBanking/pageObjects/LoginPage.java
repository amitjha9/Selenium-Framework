package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement textUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement textPassword;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	WebElement buttonLogin;
	
	@CacheLookup
	@FindBy(xpath="//a[text()=\"Log out\"]")
	WebElement buttonLogout;
	
	//Action method for the web element present on the login page
	public void setUserName(String userName)
	{
		textUserName.sendKeys(userName);
	}
	
	public void setPassword(String password) 
	{
		textPassword.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		buttonLogin.click();
	}
	
	public void clickLogoutButton()
	{
		buttonLogout.click();
	}

}
