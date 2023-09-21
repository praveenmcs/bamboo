package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooMyActivity extends Utilities{
	private static	Logger log = Logger.getLogger(BambooMyActivity.class.getName());
	public BambooMyActivity(WebDriver driver) {
		this.driver=driver;
	}
	
	@Step("My activity page section validationss")
	public BambooMyActivity validateMyActivityPage()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//span[contains(text(),' This membership year ')]")), "Current Membership year details displayed");
		Assert.assertTrue(verifyElementVisible(By.xpath("//span[contains(text(),' Recent activities ')]")), "Recent Activity list displayed");
		return this;
	}
	
	@Step("Logout from Activities Page")
	public BambooBasePage logOutFromMyActivitiesPage()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	} 
	
}
