package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooMyActivity extends Utilities{
	private static	Logger log = Logger.getLogger(BambooMyActivity.class.getName());
	Actions mouseAction = new Actions(driver);
	public BambooMyActivity(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("My activity page name validations")
	public BambooMyActivity validateMyActivityPage()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[contains(text(),'This Membership Year')]")), "Current Membership year details displayed");
		return this;
	}
	
	@Step("My activity page name validations - MembershipTier Section")
	public BambooMyActivity validateMyActivityPageMemberShipTier()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[contains(text(),'My membership tier')]")), "Current Membership year details displayed");
		return this;
	}
	
	@Step("My activity page name validations - Bonus points section")
	public BambooMyActivity validateMyActivityPageBonusPointsSection()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[contains(text(),'Bonus Points')]")), "Current Membership year details displayed");
		return this;
	}
	
	@Step("My activity page name validations - Recent Activities section")
	public BambooMyActivity validateMyActivityPageRecentActivitiesSection()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[contains(text(),'Recent Activities')]")), "Current Membership year details displayed");
		return this;
	}
	
	@Step("Logout from Activities Page")
	public BambooBasePage logOutFromMyActivitiesPage()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	} 
	
}
