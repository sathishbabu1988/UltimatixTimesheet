package com.selbot.selenium.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.selbot.testng.api.base.Annotations;

public class TimeSheetPage extends Annotations {
	
	public TimeSheetPage() {
		PageFactory.initElements(driver, this);
		Assert.assertTrue(isValid(), "Problem in loading Timesheet Page");
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='monthYearContainer']//div[contains(@class,'monthYearLabel')]")
	WebElement eleMonthHeader;
	
	@FindBy(how=How.XPATH,using="//table[@id='calenderTable']/tbody/tr/td[@class='commonCell ng-scope selectedCell']//div[@ng-model='cellList.effort' and text()='0']")
	List<WebElement> eleSelectedDates;
	
	@FindBy(how=How.XPATH,using="//table//tbody//tr//td[@id='collapsedArrow_U' and @class='sideArrow']")
	WebElement expandUnassignedTask;
	
	@FindBy(how=How.XPATH,using="//table//tbody//tr//td[@id='collapsedArrow_U' and @class='downArrow']")
	WebElement expandedUnassignedTask;
	
	@FindBy(how=How.XPATH,using="//table//thead//tr//th//span[contains(@class,'billableSpan ng-binding') and not(contains(@class,'ng-hide')) and contains(text(),'Non')]")
	WebElement eleNonbillableHeader;
	
	@FindBy(how=How.XPATH,using="//table//tbody[contains(@ng-repeat,'unassignedtask')]//tr[1]//td[contains(@ng-repeat,'unassignedtask')][2]//input[contains(@id,'effortUnassign')]")
	WebElement eleNonbillableTextbox;
	
	@FindBy(how=How.XPATH,using="//input[contains(@class,'buttonClass') and @value='Submit' and contains(@ng-click,'submitTimesheet')]")
	WebElement eleSubmitButton;
	
	
	public boolean isValid() {
		return eleMonthHeader.isDisplayed();
	}
	
	public void enterTimesheet() {
		for (WebElement eachDate : eleSelectedDates) {
			click(eachDate);
			putStaticWait(3000);
			expandUnassignedTask();
			putStaticWait(2000);
			checkNonbillableColumn();
			clearAndType(eleNonbillableTextbox, "0");
			putStaticWait(2000);
			click(eleSubmitButton);
			putStaticWait(1000);
			System.out.println("Timesheet Entered Successfully");
		}
	}
	
	public void expandUnassignedTask() {
			if(verifyDisplayed(expandUnassignedTask)) {
				click(expandUnassignedTask);
				System.out.println("Unassinged Tasks is expanded successfully");
			} else {
					if(verifyDisplayed(expandedUnassignedTask)) {
						System.out.println("Unassinged Tasks is already expanded");
					}
				}
		}
	
	public void checkNonbillableColumn() {
		boolean status = true;
		Assert.assertEquals(eleNonbillableHeader.isDisplayed(), status, "Unable to find task - PLEASE ADD TASK");
	}

}
