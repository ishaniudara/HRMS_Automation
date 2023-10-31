package com.EcommerceProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EcommerceProject.ActionDriver.ActionClass;
import com.EcommerceProject.Base.BaseClass;

public class LeavePage extends BaseClass{
	
ActionClass action=new ActionClass();
	
	@FindBy(xpath = "//a[text()='Apply']") 
	private WebElement ApplyBtn;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']") 
	private WebElement leaveTypeList;
	
	@FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']") 
	private List<WebElement> Date;
	
	@FindBy(xpath = "//button[@type='submit']") 
	private WebElement submitBtn;
	
	@FindBy(id = "oxd-toaster_1") 
	private WebElement successMsg;
	
	public LeavePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectLeaveType() {
		action.selectByValue(leaveTypeList, "CAN-Personal");
		
		
	}
	public void selectFromDate() {
		action.click(driver, Date.get(0));
		action.click(driver, leaveTypeList);
	}
	
	public void selectToDate() {
		action.click(driver, Date.get(1));
		action.click(driver, leaveTypeList);
	}
	
	public void ClickOnSubmit() {
		action.click(driver, submitBtn);
		
	}
	
	
	public String verifymsg() {
	String msg=successMsg.getText();
	return msg;
	}
	
	
	
	

}
