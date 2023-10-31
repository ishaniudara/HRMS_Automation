package com.EcommerceProject.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EcommerceProject.Base.BaseClass;
import com.EcommerceProject.PageObjects.IndexPage;
import com.EcommerceProject.PageObjects.PIMpage;
import com.EcommerceProject.Utility.Log;



public class PIMtest extends BaseClass{
	
	PIMpage pimPage;
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		launchApp(browser);
		Thread.sleep(3000);
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void addEmployee() throws InterruptedException {
		indexPage=new IndexPage();
		indexPage.clickSignIn("Admin", "admin123");
		
		Log.info("Login is successful");
		pimPage=new PIMpage();
		pimPage.clickMenu();
		pimPage.clickAddEmp();
		pimPage.enterFName();
		pimPage.enterLName();
		pimPage.verifyEmpId();
		pimPage.clickSave();
		Log.info("Employee added");
		
		
	}
}
