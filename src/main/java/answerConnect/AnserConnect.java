package answerConnect;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnserConnect {
	ChromeDriver driver;
	WebDriverWait wait;
	@Test()
	public void staging() {
		wait = new WebDriverWait(driver, 30);
		String load = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState")).toString();
		System.out.println(load);
		wait.until(ExpectedConditions.attributeToBe(
				By.xpath("//div[@class='left-col ']//h5/span[@class='msg-title']"), "class", "msg-title"));
		List<WebElement> messages = driver.findElementsByXPath("//div[@class='left-col ']//h5");
		System.out.println("Total number of messages available " + messages.size());
		List<WebElement> unreadMessage = driver.findElementsByXPath("//div[@class='left-col ']//li[@class='new ']");
		System.out.println("Unread message count "+unreadMessage.size());
		messages.get(0).click();
		WebElement firstMessage = messages.get(0).findElement(By.xpath("//div[@class='caller-details-cont']"));
		System.out.println(firstMessage.getText());
		driver.findElementByXPath("//button[@class='button nostyle']").click();
		WebElement inboxDD = driver.findElementByXPath("(//div[@class='dropdownmenu bottom'])[1]");
		List<WebElement> inboxes = inboxDD.findElements(By.tagName("a"));
		inboxes.forEach(i -> System.out.println(i.getText()));
		inboxes.get(inboxes.size()-1).click();
		
		WebElement trash = driver.findElementByClassName("trash-hint");
		wait.until(ExpectedConditions.visibilityOf(trash));
		boolean check = trash.getText().contains("30 days");
		if(check == true){
			System.out.println("Expected to be in Trash Section");
		}else {
			System.err.println("Wrong selection");
		}
		driver.findElementByXPath("//div[@class='selectall ']").click();
		driver.findElementsByXPath("(//div[@class='dropdownmenu bottom'])[2]//li")
		.forEach(i -> System.out.println(i.getText()));
	}
	
	@BeforeMethod
	void login() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://staging.access.answerconnect.com");
		driver.findElementByName("email").sendKeys("a4o@adaptavantcloud.com");
		driver.findElementByName("password").sendKeys("test123123");
		driver.findElementByClassName("button-primary ").click();
		String title = driver.getTitle();
		if(title.equals("AnswerConnect")) {
			System.out.println("Title matched proceed");
		}else {
			throw new SkipException("Title mismatched - Stop execution");
		}

	}

}
