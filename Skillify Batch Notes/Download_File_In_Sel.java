package Download_File_Date_Modified;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Download_File_In_Sel {
	
	public static void main(String[] args) {
		
		try {
			lastModifiedDate_File();
			
			HashMap<String, Object> prefsMap = new HashMap<String, Object>();
			prefsMap.put("profile.default_content_settings.popups", 0);
			prefsMap.put("download.default_directory", "Path of the download folder");
			ChromeOptions option = new ChromeOptions();
			option.setExperimentalOption("prefs", prefsMap);
			
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
									  
			// Open APP to download application
			driver.get("https://www.seleniumhq.org/download");
			  
			// Click on download 
			driver.findElement(By.xpath("//p[text()='Download version ']/a[text()='3.141.59']")).click();
			
			Thread.sleep(7000);
			File folder = new File("C:/Users/Ravi.V/Downloads");
			 
			//List the files on that folder
			File[] listOfFiles = folder.listFiles();
			boolean found = false;
			File f = null;
			     //Look for the file in the files
			     // You should write smart REGEX according to the filename
			     for (File listOfFile : listOfFiles) {
			         if (listOfFile.isFile()) {
			              String fileName = listOfFile.getName();
			               System.out.println("File " + listOfFile.getName());
			               if (fileName.matches("selenium-server-standalone-3.141.59.jar")) {
			                   f = new File(fileName);
			                   found = true;
			                   break;
			                }
			            }
			        }
			Assert.assertTrue(found, "Downloaded document is not found");
			f.deleteOnExit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void lastModifiedDate_File(){
		try {
			Path location = Paths.get("C:/Users/Ravi.V/Downloads/selenium-server-standalone-3.141.59.jar"); 
			FileTime lastModifiedTime = Files.getLastModifiedTime(location, LinkOption.NOFOLLOW_LINKS);
			System.out.println(lastModifiedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
}

}
