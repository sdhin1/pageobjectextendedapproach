package com.saudhing.zoho.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.saudhing.zoho.PageObjects.ZohoHomePage;
import com.saudhing.zoho.PageObjects.ZohoLoginPage;
import com.saudhing.zoho.utilities.DataProviders;
import com.saudhing.zoho.utilities.Constants;
import com.saudhing.zoho.utilities.DataUtil;
import com.saudhing.zoho.utilities.DriverManager;
import com.saudhing.zoho.utilities.ExcelReader;

public class LoginTest extends BaseTest{
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		
		logInfo("Launched Browser "+ data.get("browser"));
		
		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
		ZohoLoginPage login = home.goToLogin();
		
		logInfo("Username entered as "+ data.get("username") + ". Password entered as "+ data.get("password"));
		
		login.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		quit();
		
	}
	
	

}
