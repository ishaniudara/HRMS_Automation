package com.EcommerceProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EcommerceProject.ActionDriver.ActionClass;
import com.EcommerceProject.Base.BaseClass;

public class DashboardPage extends BaseClass{
	
	ActionClass action=new ActionClass();
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement title;
	
	@FindBy(xpath="///img[@alt='client brand logo']")
	WebElement profilePic;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyTitle() {
		return action.isDisplayed(driver, title);
		//action.isDisplayed(driver, profilePic);
		
	}

}
