package com.Selenium.ObjectUtilities;

import java.io.IOException;

public class ObjectUtilities {
	private static String orproperties="C:\\Users\\lokesh\\eclipse-workspace\\Framework\\src\\com\\Selenium\\ObjectRepository\\OR.properties";
	private static String gmailproperties="C:\\Users\\lokesh\\eclipse-workspace\\Framework\\src\\com\\Selenium\\ObjectRepository\\Gmail_WebElements.properties";
	private static PropertiesReusables propertiesresuables;
	static public PropertiesReusables getObjectProperties(String filepath) throws IOException
	{
		propertiesresuables=new PropertiesReusables(filepath);
		return propertiesresuables;
		
	}
	public static String getOrProperpath()
	{
		return orproperties;
	}
	public static String getGmailProperpath()
	{
		return gmailproperties;
	}
}
