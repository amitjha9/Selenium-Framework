package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
		File src = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String userName=pro.getProperty("username");
		return userName;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}
	public String getIEPath()
	{
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	public String getFireFoxPath()
	{
		String fireFoxPath=pro.getProperty("firefoxpath");
		return fireFoxPath;
	}

}
