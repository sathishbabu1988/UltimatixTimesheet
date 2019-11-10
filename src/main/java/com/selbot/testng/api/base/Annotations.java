package com.selbot.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.selbot.selenium.api.base.SeleniumBase;
import com.selbot.utils.DataLibrary;

public class Annotations extends SeleniumBase {
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}	
  
  @BeforeMethod
  public void beforeMethod() {
	  startApp("chrome", "https://www.ultimatix.net/");
	
  }

  @AfterMethod
  public void afterMethod() {
	  close();
  }

}
