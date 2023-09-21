package com.bambooui.bamboo;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pageobjects.BambooBasePage;
import utilities.Utilities;

public class Module3 extends Utilities{

	WebDriver driver;
	BambooBasePage bambBasePage = new BambooBasePage(driver);
	private static	Logger log = Logger.getLogger(Module1.class.getName());
	String className = this.getClass().getSimpleName();

	public String testdata(String key) throws IOException
	{
		return Utilities.getData(key,className);
	}

	@Test(description="Test Case to check the My Flights page")
	@Description("Test Case to check the My flights page and My flights list section")
	@Epic("Module3")
	@Story("My Flights")
	public void TS03_TC01() throws IOException, InterruptedException
	{
		bambBasePage
			.login()
			.navigateToMyFlights()
			.validateMyFlightsPageLoaded()
			.validateMyFlightsListSection()
			.logOutFromMyFlightsPage()
			;
		
	}
}
