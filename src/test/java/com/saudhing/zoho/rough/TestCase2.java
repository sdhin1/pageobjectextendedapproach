package com.saudhing.zoho.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.saudhing.zoho.utilities.DataProviders;
import com.saudhing.zoho.utilities.DriverManager;
import com.saudhing.zoho.PageObjects.ZohoHomePage;
import com.saudhing.zoho.testcases.BaseTest;

public class TestCase2 extends BaseTest {

	public WebDriver driver;

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void doLogin(String username, String password, String browser) {

		openBrowser(browser);
		
		ZohoHomePage home = new ZohoHomePage();
		
		quit();

	}

}
