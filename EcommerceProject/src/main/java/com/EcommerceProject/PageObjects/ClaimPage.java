package com.EcommerceProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.EcommerceProject.ActionDriver.ActionClass;
import com.EcommerceProject.Base.BaseClass;


public class ClaimPage extends BaseClass  {
	
	ActionClass action= new ActionClass();
	
	@FindBy(xpath = "//span[text()='Claim']") 
	private WebElement claimMenu;
	
	@FindBy(xpath = "//a[text()='Assign Claim']") 
	private WebElement assignClaim;
	
	
	@FindBy(xpath="//h6[text()='Create Claim Request']")
	private WebElement claimTitle;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement empName;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	private List<WebElement> selectList;
	
	@FindBy(tagName="textarea")
	private WebElement remark;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createBtn;
	

	
	public ClaimPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickClaimMenu() {
		action.click(driver, claimMenu);
	}
	
	public void clickAssignCliam() {
		action.click(driver, assignClaim);
	}
	
	public void enterName(String name) {
		action.type(empName, name);
	}
	
	public void selectEvenet() {
		action.click(driver, selectList.get(0));
		selectList.get(0).sendKeys(Keys.ARROW_DOWN);
		
		
	}
	public void selectCurrency() {
		action.click(driver, selectList.get(1));
		selectList.get(1).sendKeys(Keys.ARROW_DOWN);
	}
	public void enterRemark(String remarkType) {
		action.type(remark, remarkType);
	}
	public void clickCreate() {
		action.click(driver, createBtn);
	}
	
	public boolean verifyTitle() {
		return action.isDisplayed(driver, claimTitle);
	}

	
}