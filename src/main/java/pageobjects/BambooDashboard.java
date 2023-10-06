package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooDashboard extends Utilities{
	private static	Logger log = Logger.getLogger(BambooDashboard.class.getName());
	Actions mouseAction = new Actions(driver);
	public BambooDashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("Dasboard Display name validation")
	public BambooDashboard validateDashboardPage() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(10000);
		String text = getElementText(By.xpath("//span[@class='welcome-name-text']"));
		log.info(text);
		Assert.assertTrue(text.equalsIgnoreCase("Praveenkumar"), "Dashboard loaded successfully");
		return this;
	}
	
	@Step("Navigation to My Profile Page")
	public BambooProfile navigateToMyProfilePage() throws IllegalMonitorStateException, InterruptedException {
		
		waitfor(10000);
		navigateToMyProfileSectionnew();
		waitfor(3000);
		return new BambooProfile(driver);
		
	}
	
	@Step("Navigating from home page to myprofile section")
	public void navigateToMyProfileSectionnew()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//a[@href='/vn/en/bbc/my-profile']"));
	}
	@Step("Navigate to Points Calculation")
	public BambooPointsCalculator navigateToPointsCalc() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		navigateToMyProfileSectionnew();
		click(By.xpath("//li//a[@href='/vn/en/bbc/mileage-calculator']"));
		waitfor(3000);
		return new BambooPointsCalculator(driver);
	}
	@Step("Logout from Dashboard")
	public BambooBasePage logoutFromDash()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}
	@Step("Navigate to My flights page")
	public BambooMyFlights navigateToMyFlights() throws IllegalMonitorStateException, InterruptedException 
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//a[@href='/vn/en/bbc/my-profile']"));
		click(By.xpath("//p[@class='link_subName'][contains(text(),'My Flights')]"));
		waitfor(3000);
		return new BambooMyFlights(driver);
	}
	@Step("Navigate to my activity pages")
	public BambooMyActivity navigateToMyActivity() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		navigateToMyProfileSectionnew();
		click(By.xpath("//p[@class='link_subName'][contains(text(),'My  Activities')]"));
		waitfor(3000);
		return new BambooMyActivity(driver);
	}
	
	@Step("Navigating to Earn Status page")
	public EarnStatusPage navigateToEarnStatusPage() throws IllegalMonitorStateException, InterruptedException
	{
		log.info("Navigating to earn status page");
		waitfor(10000);
		navigateToMyProfileSectionnew();
		click(By.xpath("//p[@class='link_subName'][contains(text(),'Top-up Points')]"));
		waitfor(3000);
		return new EarnStatusPage(driver);
	}
	
}
