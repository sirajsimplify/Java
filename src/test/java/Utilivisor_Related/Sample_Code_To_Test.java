package Utilivisor_Related;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample_Code_To_Test {

	
	public static WebDriver driver;
	
	public static void main(String[] args) {

		 try {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://recruit.talview.com/login");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
			 //driver.switchTo().activeElement().sendKeys("");//  To point focus on the page  ==========================
			 
			 driver.findElement(By.xpath("//input[@id='identification']")).sendKeys("simplify3x+3@talview.com");
			 driver.findElement(By.xpath("//input[@id='password']")).clear();
			 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123");
			 driver.findElement(By.xpath("//button[@class='ui fluid large red submit  button']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//a[contains(text(),'Live')]")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("917795438");
			 Thread.sleep(6000);
			 driver.findElement(By.xpath("(//td[@class='lt-cell align-null text-center ember-view'])[1]")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//span[text()='Join Session']")).click();
			 Thread.sleep(5000);
			 
			 
			 
			 
			 
			 
			 // ===========================
//			 driver.findElement(By.xpath("//a[text()=' Invites ']")).click();
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("//input[@placeholder='Search Candidates']")).sendKeys("vanitha");
//			 Thread.sleep(4000);			 
//			 driver.findElement(By.xpath("(//p[text()='Vanitha C']/../../../following-sibling::td)[1]")).click();
//			 Thread.sleep(4000);
//			 driver.findElement(By.xpath("(//div[@data-position='left center'])[7]")).click();
//			 Thread.sleep(2000);
//			 
//			 DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("h:00 a");
//			 LocalDateTime now = LocalDateTime.now(); 
//			 String hour_min = dtf1.format(now);			 
//			 
//			 WebElement kk = driver.findElement(By.xpath("(//input[@class='ember-text-field ember-view'])[2]"));
//			 JavascriptExecutor ju = (JavascriptExecutor) driver;
//			 ju.executeScript("arguments[0].scrollIntoView(true);", kk);
//			 kk.click();
//			 Thread.sleep(2000);
//			 int l  = driver.findElements(By.xpath("//table[@class='ui celled center aligned unstackable table four column hour']/tbody/tr/td[text()='"+hour_min+"']")).size();
//			 if(l>0){
//			 driver.findElement(By.xpath("//table[@class='ui celled center aligned unstackable table four column hour']/tbody/tr/td[text()='"+hour_min+"']")).click();;
//			 		
//			 }
//			 Thread.sleep(1000);
//			 int po = driver.findElements(By.xpath("//*[contains(@class,'link') and text()='"+timeChange()+"']")).size();
//			 if (po>0){			 
//			 driver.findElement(By.xpath("//*[contains(@class,'link') and text()='"+timeChange()+"']")).click();;
//			 }
//			 Thread.sleep(6000);
			// System.out.println("From java.time.format.DateTimeFormatter << 12 hours format >>  " + dtf1.format(now));			 
//			 driver.findElement(By.xpath("(//*[@data-icon='user-secret'])[1]")).click();
//			 Thread.sleep(32000);				 
//					int fCount = driver.findElements(By.tagName("iframe")).size();
//					if (fCount > 0) {
//						driver.switchTo().frame(1);	
//						if (driver.findElements(By.xpath("//span[@class='margin-bottom-no text-color-white']")).size()>0){
//						System.out.println(driver.findElement(By.xpath("//span[@class='margin-bottom-no text-color-white']")).getText());
//						System.out.println(driver.findElement(By.xpath("//p[@class='margin-bottom-no ellipsis text-color-very-lightgrey']")).getText());
//						}
//						
//						else{
//							System.out.println("Not found");
//						}
//
//					} else {
//						
//					}				 
			 //driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
	}
	
	public static String timeChange(){
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("mm");
		LocalDateTime now = LocalDateTime.now(); 
		 String hour_mins =  dtf2.format(now);
		 int l = Integer.parseInt(hour_mins);
		 String Min10="";		 
		 if(l<=10)
		 {			 			DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:10 a");
			  Min10 = dtf3.format(now);			 
		 }		 
		 else if(l<=20 & l>10){			 DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:20 a");
			 Min10 = dtf3.format(now);			 
		 }
		 else if(l<=30 & l>20){			 DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:30 a");
			 Min10 = dtf3.format(now);			 
		 }
		 else if(l<=40 & l>30){			 DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:40 a");
			 Min10 = dtf3.format(now);			 
		 }
		 else if(l<=50 & l>40){			 DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:50 a");
			 Min10 = dtf3.format(now);			 
		 }
		 else if(l<=60 & l>50){			 DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("h:55 a");
			 Min10 = dtf3.format(now);			 
		 }
		return Min10;
	}

}
