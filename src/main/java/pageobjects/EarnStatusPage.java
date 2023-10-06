package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.bambooui.bamboo.Module1;

import io.qameta.allure.Step;
import utilities.Utilities;

public class EarnStatusPage extends Utilities{
	private static	Logger log = Logger.getLogger(EarnStatusPage.class.getName());
	Actions mouseAction = new Actions(driver);
	public EarnStatusPage(WebDriver driver) {
		this.driver=driver;
	}

	@Step("Validation of Topup points page url")
	public EarnStatusPage validationOfTopupPointsPageURL()
	{
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://bambooclub.bambooairways.com/vn/en/bbc/top-up-points";
		Assert.assertEquals(actualURL, expectedURL,"Topup Points page url matched");
		return this;
	}
	
	@Step("Validation of Status points and Qualfying points tabs")
	public EarnStatusPage validateStatusQualifyingPointsSection()
	{
		validateBuyBonusPointsSection();
		Assert.assertTrue(verifyElementVisible(By.xpath("//a[contains(text(),'Buy Bonus Point')]")), "Status points tab displayed");
		Assert.assertTrue(verifyElementVisible(By.xpath("//li[@onclick='onBuyQualifyingPoints(this)']//a[contains(text(),'Buy Qualifying Points/Flight Segments')]")), "Qualfying points tab displayed");
		return this;
	}
	
	@Step("Buy bonus points section")
	public EarnStatusPage validateBuyBonusPointsSection()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//div[contains(text(),'Buy Points')]")), "Bonus points section displayed");
		return this;
	}
	
	@Step("Logout from Topup point page")
	public BambooBasePage logOutFromTopUpPointsPage()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}
}
