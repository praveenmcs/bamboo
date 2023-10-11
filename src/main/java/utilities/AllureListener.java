package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import pageobjects.BambooBasePage;

public class AllureListener implements ITestListener{

	private static String getTestName(ITestResult iTestResult)
	{
		return iTestResult.getTestName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value="{0}",type ="text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	
	@Override		
    public void onFinish(ITestContext arg) {					
        System.out.println("********"+arg.getClass()+">>>TESTS FINISHED********");				
        		
    }		

    @Override		
    public void onStart(ITestContext arg) {					
    	System.out.println("********"+arg.getName()+">>>TESTS STARTED********");
    	arg.setAttribute("WebDriver", BambooBasePage.getDriver());
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg) {					
    	System.out.println("********"+arg.getName()+">>>TESTS FAILED WITH PERCENTAGE********");				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult arg) {					
    	System.out.println("********"+AllureListener.getTestName(arg)+">>>TEST FAILED********");
    	Object testClass = arg.getInstance();
        WebDriver driver = BambooBasePage.getDriver();
        if(driver instanceof WebDriver)
        {
        	System.out.println("Screenshot in prg.......");
        	saveFailureScreenShot(driver);
        	//driver.quit();
        }
        //saveTextLog(testClass.getClass().getCanonicalName()+": FAILED CASE.. Screenshot done");
    }		

    @Override		
    public void onTestSkipped(ITestResult arg) {					
    	System.out.println("********"+arg.getTestName()+">>>TEST SKIPPED********");				
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg) {					
    	//System.out.println("********"+arg.getTestName()+">>>TESTS STARTED********");     
    }		

    @Override		
    public void onTestSuccess(ITestResult arg) {					
    	System.out.println("********"+arg.getInstanceName()+">>>TESTS SUCCESS********");				
        		
    }	
}


//Trends are only for Apple to apple comparison
//Run Tests --> use allure generate command to generate HTML files with latest results
// copy history folder from allure report in c drive documents to allure results folder
//replace it no issues
//then run allure serve <allure results path>
//Now see the runs report with trend graph as well 
//Reference :https://medium.com/testvagrant/generating-allure-trendline-on-gitlab-pages-df01c8798ae2
// Reference for jenkins : https://qaautomation.expert/category/allure-report/
//https://github.com/klvl/allure-features#history-trend