package com.selbot.testcases;

import com.selbot.selenium.pages.LoginPage;
import com.selbot.testng.api.base.Annotations;

import org.testng.annotations.Test;

public class DailyTimesheetUltimatix extends Annotations {
		
@Test
public void enterTimesheet() {
	new LoginPage().enterEmployeeId().doLogin().enterTimesheet();
}

}
