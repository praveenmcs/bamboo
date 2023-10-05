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

public class Module2 extends Utilities{

	WebDriver driver;
	BambooBasePage bambBasePage = new BambooBasePage(driver);
	private static	Logger log = Logger.getLogger(Module1.class.getName());
	String className = this.getClass().getSimpleName();

	@Test
	public String testdata(String key) throws IOException
	{
		return Utilities.getData(key,className);
	}
	
	@Test(description="Test Case to check the points calculator page")
	@Description("Test Case to check the points calculator page")
	@Epic("Module2")
	@Story("Points Calculator")
	public void TS02_TC01() throws IOException, InterruptedException
	{
		bambBasePage
			.login()
			.navigateToPointsCalc()
			.validatePointsPageLoaded()
			.enterPointsQueryNew("Bamboo Airways","","Bamboo Business Flex", "HAN","BMV")
			.checkQuery()
			.logOutFromPointsPage()
			;
		
	}
	
	@AfterTest
	public void endOfClass()
	{
		bambBasePage.driver.quit();
	}
}
