package com.bambooui.bamboo;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pageobjects.BambooBasePage;
import utilities.AllureListener;
import utilities.Utilities;

public class Module1 extends Utilities{

	WebDriver driver;
	BambooBasePage bambBasePage = new BambooBasePage(driver);
	private static	Logger log = Logger.getLogger(Module1.class.getName());
	String className = this.getClass().getSimpleName();

	public String testdata(String key) throws IOException
	{
		return Utilities.getData(key,className);
	}
	
@Test(description="Test case to check Login and Landing page functionality")
@Description("Test case to check Login and Landing page functionality")
@Epic("Module1")
@Story("Login Validation")
public void TS01_TC01() throws IOException, InterruptedException
{
	bambBasePage
		.login()
		.validateDashboardPage()
		.logoutFromDash()
		;
	
}

@Test(description="Test case to Login and navigate to My Profile page and validate the basic details")
@Description("Test case to Login and navigate to My Profile page and validate the basic details")
@Epic("Module1")
@Story("Profile Validation")
public void TS01_TC02() throws IOException, InterruptedException {
	
	bambBasePage
	.login()
	.navigateToMyProfilePage()
	.validateMyProfileName(testdata("TC002.ProfileName"))
	.validateMyProfileDOB(testdata("TC002.Dob"))
	.validateMyProfileSex(testdata("TC002.Sex"))
	.validateMyProfileEmail(testdata("TC002.MailId"))
	.logoutFromProfile()
	;
}


@AfterTest
public void endOfClass()
{
	bambBasePage.driver.quit();
}
}
