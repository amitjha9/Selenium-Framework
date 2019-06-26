package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	//These variable are commons for every test case
	ReadConfig readConfig = new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public String pageTitle = "Guru99 Bank Manager HomePage";
	public String addCustomerPageSource="Customer Registered Successfully!!!";
	public static WebDriver driver;
	public static Logger logger;


	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if (br.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}
		else if (br.equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		/*
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String logFileName="inetBanking-"+timeStamp;
		String testFile = System.getProperty("user.dir")+"//inetBanking.log";
		File src = new File(testFile);
		if(src.exists())
			try {
				File.createTempFile(logFileName, ".log");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	//Add the code here to capture the screenshot.
	public void captureScreenShot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE); //This is created screenshot file
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken successfully");
	}
}
