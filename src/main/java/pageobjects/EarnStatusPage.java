package pageobjects;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.bambooui.bamboo.Module1;

import io.qameta.allure.Step;
import utilities.Utilities;

public class EarnStatusPage extends Utilities{
	private static	Logger log = Logger.getLogger(EarnStatusPage.class.getName());
	public EarnStatusPage(WebDriver driver) {
		this.driver=driver;
	}

	@Step("Validation of Topup points page")
	public EarnStatusPage validationOfTopupPointsPage()
	{
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://bambooclub.bambooairways.com/BambooAirways/topup_point";
		Assert.assertEquals(actualURL, expectedURL,"Topup Points page url matched");
		return this;
	}
	
	@Step("Validation of Status points and Qualfying points buttons")
	public EarnStatusPage validateStatusQualifyingPointsButton()
	{
		Assert.assertTrue(verifyElementVisible(By.xpath("//button[@id='buyBonusPointsButton']")), "Status points button displayed");
		Assert.assertTrue(verifyElementVisible(By.xpath("//button[@id='buyQualifyingPointsButton']")), "Qualfying points button displayed");
		return this;
	}
	
	@Step("Logout from Topup point page")
	public BambooBasePage logOutFromTopUpPointsPage()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}
}
