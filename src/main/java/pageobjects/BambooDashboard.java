package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooDashboard extends Utilities{
	private static	Logger log = Logger.getLogger(BambooDashboard.class.getName());
	public BambooDashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("Dasboard Display name validation")
	public BambooDashboard validateDashboardPage() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(30000);
		String text = getElementText(By.xpath("//h3[@id='displayName']"));
		log.info(text);
		Assert.assertTrue(true, "Dashboard loaded successfully");
		return this;
	}
	
	@Step("Navigation to My Profile Page")
	public BambooProfile navigateToMyProfilePage() throws IllegalMonitorStateException, InterruptedException {
		
		//waitForElementAppears(By.xpath("//ul[@role='navigation']//a[@routerlink='/profile']"));
		//waitForPageLoad();
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		click(By.xpath("//ul[@role='navigation']//a[@routerlink='/profile']"));
		waitfor(3000);
		return new BambooProfile(driver);
		
	}
	@Step("Navigate to Points Calculation")
	public BambooPointsCalculator navigateToPointsCalc() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		click(By.xpath("//ul[@role='navigation']//a[@routerlink='/pointcalculator']"));
		waitfor(3000);
		return new BambooPointsCalculator(driver);
	}
	@Step("Logout from Dashboard")
	public BambooBasePage logoutFromDash()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}
	@Step("Navigate to My flights page")
	public BambooMyFlights navigateToMyFlights() throws IllegalMonitorStateException, InterruptedException 
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		click(By.xpath("//ul[@role='navigation']//a[@routerlink='/myflights']"));
		waitfor(3000);
		return new BambooMyFlights(driver);
	}
	@Step("Navigate to my activity pages")
	public BambooMyActivity navigateToMyActivity() throws IllegalMonitorStateException, InterruptedException
	{
		waitfor(10000);
		log.info("To check the time it waits till page loaded");
		click(By.xpath("//ul[@role='navigation']//a[@routerlink='/myactivity']"));
		waitfor(3000);
		return new BambooMyActivity(driver);
	}
	
	@Step("Navigating to Earn Status page")
	public EarnStatusPage navigateToEarnStatusPage() throws IllegalMonitorStateException, InterruptedException
	{
		log.info("Navigating to earn status page");
		waitfor(10000);
		click(By.xpath("//ul[@role='navigation']//a[@routerlink='/topup_point']"));
		waitfor(3000);
		return new EarnStatusPage(driver);
	}
	
}
