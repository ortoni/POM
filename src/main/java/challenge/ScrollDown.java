package challenge;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		// To upload file
		WebElement upload = driver.findElementByXPath("//input[@type='file']");
		upload.sendKeys("C:\\Users\\dell\\Desktop\\PatternObjectModel\\Resume.pdf");
		
		// To scroll
		/*WebElement jobs = driver.findElementByLinkText("Browse All Jobs");
	int y = jobs.getLocation().getY();
	driver.executeScript("scroll(0, "+y+");");*/
	
	
	
	
	
	
	
		
		
	}
}
