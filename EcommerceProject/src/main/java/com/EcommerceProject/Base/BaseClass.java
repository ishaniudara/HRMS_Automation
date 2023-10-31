package com.EcommerceProject.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.EcommerceProject.Utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeSuite(groups="smoke")
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		 try {
			 
			 prop=new Properties();
			 FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\Configurations\\config.properties");
			 prop.load(ip);
			 
		 }
		
		 catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }
		
	}


	

	public static void launchApp(String browserName) {
		
		//WebDriverManager.firefoxdriver().setup();
		//String browserName=prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\OSOS\\Desktop\\Automation\\MyAutomation\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
				
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}
