package com.Selenium.BaseEngine;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriversEngine {
	private static RemoteWebDriver driver;
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("firefox")String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lokesh\\eclipse-workspace\\Framework\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			initialisation();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lokesh\\eclipse-workspace\\Framework\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			initialisation();
		}else {
			System.out.println("Please pass proper browser parameter");
		}	
	}
	public void initialisation() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	public static RemoteWebDriver getDriver()
	{
		return driver;
	}
	@AfterSuite
	public void closeBrowser() {
		if (driver!=null) {
			driver.close();
		} else {
			System.out.println("Please pass proper browser parameter");
		}
	}
	@BeforeMethod
	public void currentTestcase(Method method) {
		String tcName=method.getName();
		System.out.println("Executing:"+""+tcName);
	}
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException {
		String tcName=result.getName();
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Testcase got failed so taking screenshot");
			File file=driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\lokesh\\eclipse-workspace\\Framework\\Screenshots"+"\\"+tcName+".jpeg"));
		} else {
			System.out.println("null");
		}
	 

	}

}
