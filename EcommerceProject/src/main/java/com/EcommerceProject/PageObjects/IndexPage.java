package com.EcommerceProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EcommerceProject.ActionDriver.ActionClass;
import com.EcommerceProject.Base.BaseClass;

public class IndexPage extends BaseClass{

	ActionClass action=new ActionClass();
	
	@FindBy(xpath = "//input[@name='username']") 
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	private WebElement logo;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item']")
	private WebElement leaveMenu;
	
	
	
	//initiate web elements when calling to this class
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo() {
		return action.isDisplayed(driver, logo);
	}
	
	public DashboardPage clickSignIn(String usernameVal, String passwordVal) throws InterruptedException {
		action.type(username, usernameVal);
		action.type(password, passwordVal);
		action.click(driver, loginBtn);
		Thread.sleep(3000);
	
		return new DashboardPage();
	}
	
	public LeavePage clickOnLeaveMenu() {
		action.click(driver, leaveMenu);
		return new LeavePage();
	}

}
