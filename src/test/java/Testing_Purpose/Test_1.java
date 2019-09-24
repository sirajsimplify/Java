package Testing_Purpose;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test_1 {
	
	WebDriver driver;
	
	 @BeforeMethod
	  public void beforeMethod() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ravi.V\\Java_workspace\\Functional_Testing\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://test.utilivisor.com/login.do");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		 driver.switchTo().activeElement().sendKeys("");//  To point focus on the page  ==========================
		 
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("unidev");
		 driver.findElement(By.xpath("//input[@id='password']")).clear();
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("unidev");
		 driver.findElement(By.xpath("//input[@id='submitBut']")).click();
	  }
	
  @Test
  public void f() {
	  System.out.println("My first class");
	  
	  try {
		Thread.sleep(7000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  List<WebElement> ss = driver.findElements(By.tagName("a"));
	  int count = 0;
	  System.out.println(ss.size());
	 
	  for(int i=0; i<ss.size(); i++){
		  if(!ss.get(i).getText().isEmpty()){
			  count = count +1;
		  String kk = ss.get(i).getText();		
		 System.out.println(kk);
		 ss = driver.findElements(By.tagName("a"));
		  }
	  }
	  System.out.println("Visible links are : " + count);
  } 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("Test case completed");
  }

}
