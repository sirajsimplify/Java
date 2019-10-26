package ExtentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReportScreenshotAttach {
	
	// Create global variable which will be used in all method
	ExtentHtmlReporter reporter;
		 ExtentReports extent;
		 ExtentTest logger;
		static  WebDriver driver;
		
	        // This code will run before executing any testcase
		@BeforeMethod
		public void setup()
		{
		    reporter=new ExtentHtmlReporter("ExtentReport/ExtentReportScreenshotAttach.html");
			
		    extent = new ExtentReports();
		    
		    extent.attachReporter(reporter);
		    
		    logger=extent.createTest("LoginTest");
		}
	 
		
	        // Actual Test which will start the application and verify the title
		@Test
		public void loginTest() throws IOException
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
			System.out.println("title is "+ driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Syed"));
		}
		
	        // This will run after testcase and it will capture screenshot and add in report
		@AfterMethod
		public void tearDown(ITestResult result) throws Exception
		{
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
				String temp=getScreenshot();
				
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}
			
			extent.flush();
			driver.quit();
			
		}
		
		
		public static String  getScreenshot()
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
			
			File destination=new File(path);
			
			try 
			{
				FileHandler.copy(src, destination);
			} catch (Exception e) 
			{
				System.out.println("Capture Failed "+e.getMessage());
			}
			
			return path;
		}
		

}
