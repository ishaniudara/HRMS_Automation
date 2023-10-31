package com.EcommerceProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EcommerceProject.Base.BaseClass;
import com.EcommerceProject.PageObjects.DashboardPage;
import com.EcommerceProject.PageObjects.IndexPage;

public class DashBoardTest extends BaseClass{
	
	DashboardPage dashboardPage;
	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verifyTitle() throws InterruptedException {
		indexpage=new IndexPage();
		dashboardPage=indexpage.clickSignIn("Admin", "admin123");
		boolean expected=dashboardPage.verifyTitle();
		Assert.assertTrue(expected);
	}

}
