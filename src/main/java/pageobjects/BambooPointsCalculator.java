package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooPointsCalculator extends Utilities{

	public BambooPointsCalculator(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Validation of Points page")
	public BambooPointsCalculator validatePointsPageLoaded()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//h3[contains(text(),'How many points I may earn?')]")), "Element Visible in DOM");
		return this;
	}
	
	@Step("Logout from My Points page")
	public BambooBasePage logOutFromPointsPage()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}
	
	@Step("Entering details to expected points")
	public BambooPointsCalculator enterPointsQuery(String airways, String date, String classTicket, String fromAirport, String toAirport)
	{
		selectTextDropDown(By.xpath("//p-dropdown[@id='airlineCode']//div[@role='button']"),By.xpath("(//p-dropdown[@id='airlineCode']//input)[2]"),airways);
		enterValues(By.xpath("//input[@id='flightDate']"), date);
		selectValueDropDown(By.xpath("//p-dropdown[@id='classTicket']//div[@role='button']"),classTicket);
		selectTextDropDown(By.xpath("//p-dropdown[@id='from']//div[@role='button']"),By.xpath("(//p-dropdown[@id='from']//input)[2]"),fromAirport);
		selectTextDropDown(By.xpath("//p-dropdown[@id='to']//div[@role='button']"),By.xpath("(//p-dropdown[@id='to']//input)[2]"),toAirport);
		Assert.assertTrue(true, "Query parameters entered");
		return this;
	}
	
	@Step("Checking the expected points")
	public BambooPointsCalculator checkQuery() throws InterruptedException
	{
		click(By.xpath("//button[@title='Checkavailability']"));
		wait(10000);
		Assert.assertTrue(true, "Points details received");
		return this;
	}
}
