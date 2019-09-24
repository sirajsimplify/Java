package Utilivisor_Related;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Test started");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://qa.utilivisor.com/login.do");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		 //   driver.switchTo().activeElement().sendKeys("");//  To point focus on the page  ==========================
		 
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("unidev");
		 driver.findElement(By.xpath("//input[@id='password']")).clear();
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unidev16690");
		 driver.findElement(By.xpath("//input[@id='submitBut']")).click();
		 Thread.sleep(5000);
		 
		 String parent = driver.getWindowHandle();
		 System.out.println("Parent window Id is " + parent);
		 WebElement wind = driver.findElement(By.xpath("//a[text()='Administration']"));
		 
		 wind.click();
		 
		 Set<String> allWindowHandles = driver.getWindowHandles();
		 for(String handle : allWindowHandles)
		 {
			 if(!handle.equals(parent)){
		 System.out.println("Window handle - > " + handle);
		 driver.switchTo().window(handle);
		 Actions action1 = new Actions(driver);
		 action1.moveToElement(driver.findElement(By.xpath("//img[@alt='Billing System']"))).build().perform();
		 
		driver.findElement(By.xpath("//img[@alt='Billing System']/../../following-sibling::ul[@class='subNavigation']/li/a/span[text()='Reports']")).click();
		Thread.sleep(5000);
		Actions action2 = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//div[@class='x-fieldset-body ux-mselect']/div[text()='1 Allen Center']"));
		WebElement dest = driver.findElement(By.xpath("//span[text()='Selected']/../following-sibling::div/div"));
		//action2.clickAndHold(source).release(dest).build().perform();
		action2.dragAndDrop(source, dest).build().perform();
		Thread.sleep(3000);
			 }}	 
		//div[@class='x-fieldset-body ux-mselect']/div[text()='1 Allen Center']
		//div[@class='x-fieldset-body ux-mselect']/div[text()='1 Barker Avenue']

		 driver.switchTo().window(parent);
		 Thread.sleep(4000);
		 
		 
		 
		 System.out.println("Test completed");
	}

}
