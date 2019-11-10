package com.selbot.selenium.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selbot.testng.api.base.Annotations;

import org.testng.Assert;

public class LoginPage extends Annotations {
	
	public final String employeeId = "734754";
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		Assert.assertTrue(isValid(), "Problem in loading Login Page");
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='username-input']/input")
	WebElement eleUsername;
	
	@FindBy(how=How.XPATH,using="//button[@id='proceed-button']")
	WebElement eleProceedButton;
	
	public boolean isValid() {
		return eleUsername.isDisplayed();
	}
	
	public PasswordPage enterEmployeeId() {
		clearAndType(eleUsername, employeeId);
		click(eleProceedButton);
		return new PasswordPage();
	}

}
