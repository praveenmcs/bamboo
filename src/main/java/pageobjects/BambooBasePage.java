package pageobjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.bambooui.bamboo.Module1;

import io.qameta.allure.Step;
import utilities.Utilities;

public class BambooBasePage extends Utilities{

	private static	Logger log = Logger.getLogger(Module1.class.getName());
	String envFilePath = "src\\main\\resources\\credentials\\cred.properties";
	public static Properties cred=new Properties();
	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public BambooBasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public BambooBasePage setup() throws IOException 
	{
		FileReader reader = new FileReader(envFilePath);
		cred.load(reader);
		System.setProperty("webdriver.chrome.driver", "D://Personal/Learning/bamboo/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		tdriver.set(driver);
		String url = cred.getProperty("bambooprodurl");
		log.info(url);
		driver.get(url);
		return this;
	}
	
	
	public BambooBasePage setupWithClassName(String className) throws IOException 
	{
		FileReader reader = new FileReader(envFilePath);
		cred.load(reader);
		
		System.setProperty("webdriver.chrome.driver", "D://Personal/Learning/bamboo/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		tdriver.set(driver);
		String url = cred.getProperty("bambooprodurl");
		log.info(url);
		driver.get(url);
		return this;
	}

	@Step("Application Log in")
	public BambooDashboard login() throws IOException, InterruptedException{
		setup();
		log.info("Entering credentials");
		click(By.xpath("//div[@class='ui-dropdown-label-container']"));
		click((By.xpath("//li[@aria-label='english']")));
		enterValues(By.xpath("//input[@formcontrolname='username']"),cred.getProperty("username"));
		enterValues(By.xpath("//input[@formcontrolname='password']"),cred.getProperty("password"));
		click(By.xpath("//button[@id='loginButton']"));
		log.info("Username and password entered");
		Reporter.log("test");
		return new BambooDashboard(driver);
	}
	
	public BambooDashboard loginWithClassName(String className) throws IOException, InterruptedException{
		setupWithClassName(className);
		log.info("Entering credentials");
		click(By.xpath("//div[@class='ui-dropdown-label-container']"));
		click((By.xpath("//li[@aria-label='english']")));
		enterValues(By.xpath("//input[@formcontrolname='username']"),cred.getProperty("username"));
		enterValues(By.xpath("//input[@formcontrolname='password']"),cred.getProperty("password"));
		click(By.xpath("//button[@id='loginButton']"));
		log.info("Username and password entered");
		return new BambooDashboard(driver);
	}

	public void waitForPageLoad() {
		
		boolean text=jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		log.info("state:"+text);
}
	
	public static synchronized WebDriver getDriver()
	{
		return tdriver.get();
	}
}
