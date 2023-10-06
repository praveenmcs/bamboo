package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooProfile extends Utilities{
	Actions mouseAction = new Actions(driver);
	public BambooProfile(WebDriver driver) {
		this.driver=driver;
	}

	@Step("My Profile Name validated")
	public BambooProfile validateMyProfileName(String name) {
		 String actualName = getElementText(By.xpath("//span[@id='full-name-hodler']"));
		 Assert.assertEquals(actualName, name,"Profile name matched");
		return this;
	}

	@Step("My Profile DOB validated")
	public BambooProfile validateMyProfileDOB(String dob) {
		String actualDob = getElementText(By.xpath("//form[@id='personalInformationForm']//div[contains(text(),'Date of Birth')]//parent::div/div[2]"));
		Assert.assertEquals(actualDob, dob,"Dateof birth matched");
		return this;
	}

	@Step("My Profile Sex validated")
	public BambooProfile validateMyProfileSex(String sex) {
		String actualSex = getElementText(By.xpath("//form[@id='personalInformationForm']//div[contains(text(),'Gender')]//parent::div/div[2]"));
		Assert.assertEquals(actualSex, sex,"Sex of the person matched");
		return this;
	}

	@Step("My Profile Email validated")
	public BambooProfile validateMyProfileEmail(String email) {
		//String actualEmail = getElementText(By.xpath("//p[@class='boldtxt'][@id='email']"));
		String actualEmail = getElementAttributeValue(By.xpath("//input[@id='email-input']"));
		Assert.assertEquals(actualEmail, email,"Email matched");
		return this;
	}
	
	@Step("Logged out from profile")
	public BambooBasePage logoutFromProfile()
	{
		mouseAction.moveToElement(driver.findElement(By.xpath("//div[@id='nav-small-user-name']"))).build().perform();
		click(By.xpath("//div[@id='logout-button']"));
		driver.switchTo().alert().accept();
		Assert.assertTrue(true, "Clicked on logout");
		return new BambooBasePage(driver);
	}

}
