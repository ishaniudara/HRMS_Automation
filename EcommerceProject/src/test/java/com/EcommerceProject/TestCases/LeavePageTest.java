/**
 * 
 */
package com.EcommerceProject.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.EcommerceProject.Base.BaseClass;
import com.EcommerceProject.PageObjects.DashboardPage;
import com.EcommerceProject.PageObjects.IndexPage;
import com.EcommerceProject.PageObjects.LeavePage;

/**
 * @author OSOS
 *
 */
/**
*/
public class LeavePageTest extends BaseClass{
	
	// this object can use through test case
		IndexPage obj;
		LeavePage leavePage;
		
		
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
		
		public void applyLeave() {
			obj=new IndexPage();
			leavePage=obj.clickOnLeaveMenu();
			leavePage.selectLeaveType();
			leavePage.selectFromDate();
			leavePage.selectToDate();
			leavePage.ClickOnSubmit();
			Assert.assertEquals("Successfully saved",leavePage.verifymsg());
			
			
		}
		

}
