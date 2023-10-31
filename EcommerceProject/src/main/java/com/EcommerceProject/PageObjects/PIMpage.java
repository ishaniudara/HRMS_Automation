package com.EcommerceProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EcommerceProject.ActionDriver.ActionClass;
import com.EcommerceProject.Base.BaseClass;

public class PIMpage extends BaseClass
{
ActionClass action=new ActionClass();
	
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']") 
	private WebElement menuBtn;
	
	@FindBy(xpath = "//a[text()='Add Employee']") 
	private WebElement addEmpBtn;
	
	@FindBy(name = "firstName") 
	private WebElement fName;
	
	@FindBy(name = "lastName") 
	private WebElement lName;
	
	@FindBy(xpath = "//label[text()='Employee Id']") 
	private WebElement EmpId;
	
	@FindBy(xpath = "//button[@type='submit']") 
	private WebElement saveBtn;
	

	public PIMpage() {
		PageFactory.initElements(driver, this);
	}

	public void clickMenu() {
		action.click(driver, menuBtn);
	}
	
	public void clickAddEmp() {
		action.click(driver, addEmpBtn);
	}
	 
	public boolean enterFName() {
		return  action.type(fName, "Udara");
		
	}
	public boolean enterLName() {
		return  action.type(lName, "Randika");
		
	}
	
	
	public void verifyEmpId() {
		action.isDisplayed(driver, EmpId);
	}
	
	public void clickSave() {
		action.click(driver, saveBtn);
	}
}
