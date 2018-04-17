package com.Selenium.BussinessScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Selenium.BaseEngine.DriversEngine;
import com.Selenium.ObjectUtilities.ObjectUtilities;
import com.Selenium.ObjectUtilities.PropertiesReusables;

public class GmailTest extends DriversEngine {
	@Test
	public void gmailLogin() throws IOException {
		PropertiesReusables orprop=new PropertiesReusables(ObjectUtilities.getOrProperpath());
		String url=orprop.getPropertyValue1("gmail");
		getDriver().get(url);
		PropertiesReusables gmailprop=new PropertiesReusables(ObjectUtilities.getGmailProperpath());
		String us=gmailprop.getPropertyValue1("username");
		getDriver().findElement(By.id(us)).sendKeys("abc");

	}

}
