package MyFirstClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Log4jClass {
	
	// 1. What is Log4j files  
	//(Log4j is an open source logging framework. With log4j – logging behavior can be controlled by editing a configuration 
	// file only without touching the application binary and can be used to store the Selenium Automation flow logs.)
	// 2. how to configure log4J (Download the jar of log4j and add to buildpath)
	// 3. How to write properties file
	// 4. How to use Log4j
	// 5. Check Log4j file for the testcase
	
	// Log folder gets created with 3 different files application.html, testlog.log, testlog1.log
	
	static WebDriver driver;
	
	public static void main(String[] args) {
	try {
		Logger logger = Logger.getLogger("Log4jClass");  // Create a class of log4j
		
		PropertyConfigurator.configure("Log4j/Log4j.properties"); // configue the properties file
		
		System.out.println("Testing-1");
		logger.info("Testing-1");
		Thread.sleep(3000);
		logger.info("I am waiting for 3 sec");
		WebDriver driver= null;
				
		System.out.println("Testing-2");
		logger.info("Testing-21");
		
//		System.out.println("Test started");
//		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
//		 driver = new ChromeDriver();
//		 logger.info("Chrome browser launched");
//		 
//		 driver.manage().window().maximize();
//		 driver.get("http://qa.utilivisor.com/login.do");
//		 logger.info("Application launched");
//		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
//		 //   driver.switchTo().activeElement().sendKeys("");//  To point focus on the page  ==========================
//		 
//		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("unidev");
//		 logger.info("Entering the username");
//		 driver.findElement(By.xpath("//input[@id='password']")).clear();
//		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unidev16690");
//		 logger.info("Entered password");
//		 driver.findElement(By.xpath("//input[@id='submitBut']")).click();
//		 Thread.sleep(5000);
//		 
//		 String parent = driver.getWindowHandle();
//		 System.out.println("Parent window Id is " + parent);
//		 WebElement wind = driver.findElement(By.xpath("//a[text()='Administration']"));
//		 
//		 wind.click();
//		 Thread.sleep(5000);
//		 System.out.println("Test completd");
//		 driver.quit();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
