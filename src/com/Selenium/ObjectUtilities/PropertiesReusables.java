package com.Selenium.ObjectUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReusables {
	private String filepath;
	private FileInputStream fip;
	private Properties property;
	public PropertiesReusables(String filepath) throws IOException
	{
		this.filepath=filepath;
		fip=new FileInputStream(filepath); 
		property=new Properties();
		property.load(fip);
	}
	public String getPropertyValue1(String key) {
			String value=property.getProperty(key);
			return value;
		
	}
	public void setPropertyValue1(String key, String value) throws FileNotFoundException, IOException {
		if (key!=null) {
			property.setProperty(key, value);
			property.store(new FileOutputStream(filepath), "added");
		} else {
			System.out.println("Properties object is pointing to null");
		}
	}
	public void removePropertyValue1(String key) throws FileNotFoundException, IOException {
		property.remove(key);
		property.store(new FileOutputStream(filepath), "Removed");
	}

}
