package challenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDemo {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		// To run in background
		op.setHeadless(true);
		// To disable browser notifications
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		driver.get("https://www.myntra.com");
		System.out.println(driver.getTitle());
		
	}

}
