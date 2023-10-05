package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooMyFlights extends Utilities{
	private static	Logger log = Logger.getLogger(BambooDashboard.class.getName());
	Actions mouseAction = new Actions(driver);
	public BambooMyFlights(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("MyFlights History page loaded")
	public BambooMyFlights validateMyFlightsPageLoaded(){
		
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[@class='flight-history']")), "MyFlights history page loaded");
		log.info("My flights page loaded successfully");
		return this;
	}
	
	@Step("Upcomind Flights sections loaded in page")
	public BambooMyFlights validateMyUpcomingFlightsListSection(){
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[@id='upcomingFlightsContainer']")), "My upcoming Flights list section displayed");
		return this;
	}
	
	@Step("Logout from My flights page")
	public BambooDashboard logOutFromMyFlightsPage()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooDashboard(driver);
	}
}
