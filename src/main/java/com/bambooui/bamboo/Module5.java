package com.bambooui.bamboo;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pageobjects.BambooBasePage;
import utilities.Utilities;

public class Module5 extends Utilities{

	WebDriver driver;
	BambooBasePage bambBasePage = new BambooBasePage(driver);
	private static	Logger log = Logger.getLogger(Module5.class.getName());
	String className = this.getClass().getSimpleName();

	@Test
	public String testdata(String key) throws IOException
	{
		return Utilities.getData(key,className);
	}

	@Test(description="Test Case to check the Earn status page")
	@Description("Test Case to check the Earn Status page is loaded and Bonus and QUalification points button is displayed")
	@Epic("Module5")
	@Story("Earn Status Points")
	public void TS05_TC01() throws IOException, InterruptedException
	{
		bambBasePage
			.login()
			.navigateToEarnStatusPage()
			.validationOfTopupPointsPage()
			.validateStatusQualifyingPointsButton()
			.logOutFromTopUpPointsPage()
			;
		
	}
	
	@AfterTest
	public void endOfClass()
	{
		bambBasePage.driver.quit();
	}
}
