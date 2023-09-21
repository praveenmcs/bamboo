package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities{
	
	private static	Logger log = Logger.getLogger(Utilities.class.getName());
	protected static WebDriver driver;
	public static Properties data = new Properties();
	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	
	public static String getData(String key,String className) throws IOException
	{
		FileReader dataReader = new FileReader("src\\test\\resources\\testdata\\"+className+".properties");
		data.load(dataReader);
		return data.getProperty(key); 
	}
	public void click(By ele){
		log.info("element to click is:"+ele);	
		driver.findElement(ele).click();
	}
	
	public boolean verifyElementVisible(By ele)
	{
		log.info("Checking Element:"+ele+" is displayed in the DOM or not");
		return driver.findElement(ele).isDisplayed(); 
	}
	
	public void enterValues(By ele, String value){
		driver.findElement(ele).sendKeys(value);
	}
	
	public String getElementText(By ele){
		return driver.findElement(ele).getText();
	}
	
	
	public void waitfor(long waitime) throws IllegalMonitorStateException, InterruptedException{
		Thread.sleep(waitime);
	}
	
	public void waitForElementDisappears(By ele){
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(ele)));
	}
	
	public void waitForElementAppears(By ele){
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(ele));
		driver.findElement(ele).getTagName();
	}
	
	public void waitForPageLoad() {
		log.info(jsExecutor.executeScript("document.readyState").toString());
		
}
	
	public void selectTextDropDown(By dropdwnele,By dropdwninp, String value)
	{
		click(dropdwnele);
		enterValues(dropdwninp, value);
		driver.findElement(dropdwninp).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(dropdwninp).sendKeys(Keys.ENTER);
		log.info(value+": selected from dropdown");
	}
	
	public void selectValueDropDown(By dropdwnele,String value)
	{
		click(dropdwnele);
		if(value.length()>0){
		click(By.xpath("//p-dropdown[@id='classTicket']//ul//li[@aria-label='Point_calculator.b_excl']"));
		}
		//For now it always selects business exclusive
		log.info(value+": selected from dropdown");
	}
	

}