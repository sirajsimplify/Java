package ExtentReportFromStart;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.*;

public class ExtentReportVersion_4 {
	
	public static WebDriver driver;
	
	// ExtentHtmlReporter(Responsible for look and feel of the report), 
	//ExtentReports (To create entries in report), 
	//ExtentTest(Update status of the test in report pass or fail)
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent()
	{		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReport/ExtentreportV4.html"); // File where the report gets stored
		htmlreporter.config().setDocumentTitle("Automation report"); // Title of the report
		htmlreporter.config().setReportName("Functional Report");  // Report name
		htmlreporter.config().setTheme(Theme.DARK);  // To set the theme 
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);  // attach reporter to the extent report
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("HostName", "Skillify");
		extent.setSystemInfo("Environment", "Testing");
		extent.setSystemInfo("Tester name", "Siraj");
		extent.setSystemInfo("Browser name", "Chrome");				
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		driver.get("https://recruit.talview.com/login");		
	}
	
	@Test
	public void verifyLoginPage()
	{
		test = extent.createTest("verifyLoginPage", "This gives the information on the page login");  // A new entry of the test case in the report gets created
		String title = driver.getTitle();
		test.log(Status.INFO, "verifyLoginPage test started");
		Assert.assertTrue(title.contains("Recruit | Login tt"));
	}
	
	@Test
	public void verifySignInText()
	{
		try {
			test = extent.createTest("verifySignInText", "This verifies the signin text");  // A new entry of the test case in the report gets created
			boolean np = driver.findElement(By.xpath("//div[@class='ui inverted green segment']")).getText().contains("SIGN IN HERE");
			String name = new Object(){}.getClass().getEnclosingMethod().getName();
			String screenshotpath = getScreenshot(name);
			test.addScreenCaptureFromPath(screenshotpath);
			test.log(Status.INFO, "verifySignInText test started");
			Assert.assertTrue(np);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void verifyText()
	{
		test = extent.createTest("verifyText", "This identifies the test");  // A new entry of the test case in the report gets created
		boolean np = driver.findElement(By.xpath("//button[@class='ui fluid large red submit  button']")).getText().contains("Sign In");
		Assert.assertTrue(np);		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception // ITestResult has status of each test result
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed is = " + result.getName());  // adds the name of the failed test in the report
			test.log(Status.FAIL, "Test case failed is = " + result.getThrowable());  // gets the exception to the report
			String screenshotpath = getScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotpath);  // Adding screenshot for the extent report			
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case Skipped is = " + result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case Passed is = " + result.getName());
		}	
		driver.quit();
	}
	
	public static String getScreenshot(String screenShotName){
		String imgDest = null;
		try {
			String dt =new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
			 TakesScreenshot scrShot =((TakesScreenshot)driver);
			  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);   
			  imgDest = System.getProperty("user.dir") + "/Screenshots/" + screenShotName +"-"+ dt + ".png";
			  File dest = new File(imgDest);
			  FileUtils.copyFile(SrcFile, dest);			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgDest;
	}

}
