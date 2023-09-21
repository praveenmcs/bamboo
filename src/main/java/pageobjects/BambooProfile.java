package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooProfile extends Utilities{

	public BambooProfile(WebDriver driver) {
		this.driver=driver;
	}

	@Step("My Profile Name validated")
	public BambooProfile validateMyProfileName(String name) {
		 String actualName = getElementText(By.xpath("//p[@class='nametxt']"));
		 Assert.assertEquals(actualName, name,"Profile name matched");
		return this;
	}

	@Step("My Profile DOB validated")
	public BambooProfile validateMyProfileDOB(String dob) {
		String actualDob = getElementText(By.xpath("//div[@class='row bottomspacer']/div[2]//p[@class='boldtxt']"));
		Assert.assertEquals(actualDob, dob,"Dateof birth matched");
		return this;
	}

	@Step("My Profile Sex validated")
	public BambooProfile validateMyProfileSex(String sex) {
		String actualSex = getElementText(By.xpath("//div[@class='row bottomspacer']/div[3]//p[@class='boldtxt']"));
		Assert.assertEquals(actualSex, sex,"Sex of the person matched");
		return this;
	}

	@Step("My Profile Email validated")
	public BambooProfile validateMyProfileEmail(String email) {
		String actualEmail = getElementText(By.xpath("//p[@class='boldtxt'][@id='email']"));
		Assert.assertEquals(actualEmail, email,"Email matched");
		return this;
	}
	
	@Step("Logged out from profile")
	public BambooBasePage logoutFromProfile()
	{
		click(By.xpath("//a[@id='logoutButton']"));
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}

}
