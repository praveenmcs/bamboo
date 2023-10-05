package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice.Return;
import utilities.Utilities;

public class BambooPointsCalculator extends Utilities{
	Actions mouseAction = new Actions(driver);
	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	public BambooPointsCalculator(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Points calculator page load validation")
	public BambooPointsCalculator validatePointsPageLoaded()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[@class='title-points-calculator text-uppercase']")), "Element Visible in DOM");
		return this;
	}
	
	@Step("Logout from My Points page")
	public BambooBasePage logOutFromPointsPage()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
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
	
	@Step("Entering details to expected points")
	public BambooPointsCalculator enterPointsQueryNew(String airways, String date, String classTicket, String fromAirport, String toAirport)
	{
		
		click(By.xpath("//input[@name='fromCalLocation']"));
		enterValues(By.xpath("//input[@name='fromCalLocation']"),fromAirport);
		String script = "document.querySelector(\"#lists-location-vn > ul > li[data-code='"+fromAirport+"']\").click()";
		jsExecutor.executeScript(script);
		
		enterValues(By.xpath("//input[@name='toCalLocation']"),toAirport);
		script = "document.querySelector(\"#lists-location-vn-to > ul > li[data-code='"+toAirport+"']\").click()";
		jsExecutor.executeScript(script);
		
		click(By.xpath("//input[@id='departDateCal']"));
		click(By.xpath("//div[@class='calendar-table']//td[@class='available'][2]")); // click on second available date

		selectValueDropDown(By.xpath("//input[@id='selectAirlineId']"),airways);
		selectValueDropDown(By.xpath("//input[@id='selectTicketClassId']"),classTicket);
		
		Assert.assertTrue(true, "Query parameters entered");
		return this;
	}
	
	@Step("Checking the expected points")
	public BambooPointsCalculator checkQuery() throws InterruptedException
	{
		click(By.xpath("//button[@id='btnSubmit']"));
		Thread.sleep(10000);
		Assert.assertTrue(true, "Points details received");
		String points = getElementText(By.xpath("//span[@id='bonus-points']"));
		System.out.println(points);
		return this;
	}
}


//String readState = "document.readyState";
//if(jsExecutor.executeScript(readState).toString().equalsIgnoreCase("complete"))
//{
//	jsExecutor.executeScript(script);
//}
//