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

public class Module6 extends Utilities{

	WebDriver driver;
	BambooBasePage bambBasePage = new BambooBasePage(driver);
	private static	Logger log = Logger.getLogger(Module6.class.getName());
	String className = this.getClass().getSimpleName();

	@Test
	public String testdata(String key) throws IOException
	{
		return Utilities.getData(key,className);
	}

	@Test(description="Test Case to search and book a flight")
	@Description("Test Case to check the user is able to search and book a flight")
	@Epic("Module6")
	@Story("Book a flight")
	public void TS06_TC01() throws IOException, InterruptedException
	{
		bambBasePage
			.login()
			.selectOneWay(true)
			.enterSearchFlights("HAN","CXR")
			.selectDate()
			.clickOnSearch()
			;
		
	}
	
	@AfterTest
	public void endOfClass()
	{
		bambBasePage.driver.quit();
	}
}
