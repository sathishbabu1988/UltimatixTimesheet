package com.selbot.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selbot.testng.api.base.Annotations;

public class PasswordPage extends Annotations {

	public final String timesheetUrl = "https://timesheet.ultimatix.net/timesheet/";
	public final String password = "Novv@2019";
	
	public PasswordPage() {
		PageFactory.initElements(driver, this);
		Assert.assertTrue(isValid(), "Problem in loading Password Page");
	}
		
	@FindBy(how=How.XPATH,using="//button[@id='password-btn']")
	WebElement elePasswordButton;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'password-input')]/input")
	WebElement elePassword;
	
	@FindBy(how=How.XPATH,using="//button[@id='form-submit']")
	WebElement eleLoginButton;
	
	public boolean isValid() {
		return elePasswordButton.isDisplayed();
	}
	
	public TimeSheetPage doLogin() {
		click(elePasswordButton);
		clearAndType(elePassword, password);
		click(eleLoginButton);
		driver.get(timesheetUrl);
		return new TimeSheetPage();
	}
}
