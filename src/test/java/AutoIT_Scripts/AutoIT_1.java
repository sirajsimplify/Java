package AutoIT_Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoIT_1 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ravi.V\\Java_workspace\\Functional_Testing\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://s000.tinyupload.com/index.php?");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
		 driver.findElement(By.name("uploaded_file")).click();
		 Thread.sleep(3000);
		 Runtime.getRuntime().exec("F:\\AutoIt\\uploadScript.exe");
		 Thread.sleep(3000);
	}

}
