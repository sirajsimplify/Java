package Utilivisor_Related;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_Concept {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.out.println("Test started");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://toolsqa.com/iframe-practice-page/");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		 numberOfFrames();
		 //switchToFrameByIndex();
		 switchToFrameById();
		 switchToFrameByName();
		 switchToFrameByWebElement();
		 switchBackToMainPage();
		 driver.quit();	
	}
	
	public static void numberOfFrames(){
				//By executing a java script
				JavascriptExecutor exe = (JavascriptExecutor) driver;
				Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
				System.out.println("Number of iframes on the page are " + numberOfFrames);

				//By finding all the web elements using iframe tag
				List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
				System.out.println("The total number of iframes are " + iframeElements.size());
	}
	
	public static void switchToFrameByIndex(){
		driver.switchTo().frame(2);	
		 driver.switchTo().parentFrame();
		}
	
	public static void switchToFrameById(){
		driver.switchTo().frame("IF1");
		 driver.switchTo().parentFrame();
		}
	
	public static void switchToFrameByName(){
		driver.switchTo().frame("iframe1");
		 driver.switchTo().parentFrame();
	}
	
	public static void switchToFrameByWebElement(){
		WebElement iframeElement = driver.findElement(By.id("IF1"));
		driver.switchTo().frame(iframeElement);
		 driver.switchTo().parentFrame();
	}
	
	public static void switchBackToMainPage(){
		//WebElement iframeElement1 = driver.findElement(By.id("IF1"));
		 
		 //now use the switch command
		 driver.switchTo().frame(0);
		 
		 //Do all the required tasks in the frame 0
		 //Switch back to the main window
		 driver.switchTo().defaultContent(); 
		 // driver.switchTo().parentFrame();
	}

}
