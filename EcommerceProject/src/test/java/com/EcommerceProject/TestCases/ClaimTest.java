package com.EcommerceProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EcommerceProject.Base.BaseClass;
import com.EcommerceProject.DataProvider.DataProviders;
import com.EcommerceProject.PageObjects.ClaimPage;
import com.EcommerceProject.PageObjects.DashboardPage;
import com.EcommerceProject.PageObjects.IndexPage;

import jdk.internal.org.jline.utils.Log;

public class ClaimTest extends BaseClass{
	
	IndexPage indexPage;
	ClaimPage claimPage;
	DashboardPage dashboardPage;

	
	@Parameters("browser")
	@BeforeMethod(groups="smoke")
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
		Thread.sleep(3000);
		
		
	}
	@AfterMethod(groups="smoke")
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="smoke", dataProvider="AssignClaim", dataProviderClass=DataProviders.class)
	public void assignClaim(String empName, String remark) throws InterruptedException {
		
		indexPage=new IndexPage();
		dashboardPage=indexPage.clickSignIn("Admin", "admin123");
//		Log.info("Login successful");
		Thread.sleep(3000);
		
		claimPage=new ClaimPage();
		claimPage.clickClaimMenu();
//		Log.info("User clicked on claim in menu");
		Thread.sleep(2000);
		claimPage.clickAssignCliam();
//		Log.info("User clicked on Assign claim ");
		Thread.sleep(3000);
		Assert.assertTrue(claimPage.verifyTitle());
//		Log.info("Verified title");
		
		claimPage.enterName(empName);
//		Log.info("Entered Employee name");
		Thread.sleep(6000);
		claimPage.selectEvenet();
//		Log.info("Selected event");
		Thread.sleep(3000);
		claimPage.selectCurrency();
//		Log.info("Selected Currency");
		Thread.sleep(3000);
		claimPage.enterRemark(remark);
//		Log.info("Entered remark");
		Thread.sleep(2000);
		claimPage.clickCreate();
//		Log.info("Claim created successful");
		
	}
	

}
