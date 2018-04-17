package com.Selenium.BaseEngine;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void main(String[] args) {
		Logger logger=Logger.getLogger("Test");
		PropertyConfigurator.configure("C:\\Users\\lokesh\\eclipse-workspace\\Framework\\log4j.properties");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lokesh\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("http://www.gmail.com");
		logger.info("Browser launched");
	}

}
