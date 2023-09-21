package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooMyFlights extends Utilities{
	private static	Logger log = Logger.getLogger(BambooDashboard.class.getName());
	public BambooMyFlights(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("Validation of My flights page")
	public BambooMyFlights validateMyFlightsPageLoaded(){
		
		Assert.assertTrue(verifyElementVisible(By.xpath("//a[@href='#historydetails']")), "MyFlights page loaded");
		log.info("My flights page loaded successfully");
		return this;
	}
	
	@Step("Validation of My flights list section")
	public BambooMyFlights validateMyFlightsListSection(){
		Assert.assertTrue(verifyElementVisible(By.xpath("//h3[contains(text(),'My flight list')]")), "My Flights list section displayed");
		return this;
	}
	
	@Step("Logout from My flights page")
	public BambooDashboard logOutFromMyFlightsPage()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooDashboard(driver);
	}
}
