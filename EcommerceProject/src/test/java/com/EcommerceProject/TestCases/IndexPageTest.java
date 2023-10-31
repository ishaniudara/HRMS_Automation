package com.EcommerceProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EcommerceProject.Base.BaseClass;
import com.EcommerceProject.DataProvider.DataProviders;
import com.EcommerceProject.PageObjects.DashboardPage;
import com.EcommerceProject.PageObjects.IndexPage;
import com.beust.jcommander.Parameter;

import jdk.internal.org.jline.utils.Log;

public class IndexPageTest extends BaseClass {
	
	// this object can use through test case
	IndexPage obj;
	DashboardPage dashboardPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups="smoke")
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
		Thread.sleep(3000);
		
		
	}
	
	@Test(groups="smoke")
	public void verifyLogo() {
		
		
		obj=new IndexPage();
		boolean result=obj.verifyLogo();
		Assert.assertTrue(result);
		//Log.info("Logo is available");
	}
	
	@Test(dataProvider="crendentials", dataProviderClass=DataProviders.class, groups="smoke")
	public void login(String uname, String pwd) throws InterruptedException {
		new IndexPage().clickSignIn(uname, pwd);
		//Log.info("User has logged");
		
	}
	
	
	@AfterMethod(groups="smoke")
	public void tearDown() {
		driver.quit();
	}
	
	

}
