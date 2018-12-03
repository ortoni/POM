package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Report;

public class SeMethods extends Report implements WdMethods{
	public int i = 1;
	public  RemoteWebDriver driver;

	@Override
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("ff")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			reportStep("The browser: "+browser+" launched successfully", "pass");
		} catch (WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "fail");
		}
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "name" : return driver.findElementByName(locValue);
			case "linktext" : return driver.findElementByLinkText(locValue);
			case "partialLink" : return driver.findElementByPartialLinkText(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "cssSelect" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "fail");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "fail");
		}
		finally {
			takeSnap();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {	
			text = ele.getText();
			ele.click();			
			reportStep("The element :"+text+"  is clicked.", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","fail");
		} 
	}

	
	@Override
	public void click(WebElement ele) {
		String text = "";
		try {			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "pass");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "fail");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "fail");
		} 
	}

	@Override
	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		}
		return bReturn;
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "fail");
		} 
		return bReturn;
	}
	
	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		} 
		return bReturn;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"pass");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"pass");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "fail");
		} 
	}

	@Override
	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"pass");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "fail");
		} 
		return bReturn;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"pass");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "fail");
		} 

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "fail");
		} 

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "fail");
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","pass");
			} else {
				reportStep("The element "+ele+" is not selected","fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","pass");
			} else {
				reportStep("The element "+ele+" is not visible","fail");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "f");
		} 
	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"pass");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}
	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"pass");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		} 
	}

	@Override
	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		}  
	}

	@Override
	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		} 
	}

	@Override
	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","fail");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "fail");
		} 
		return text;
	}

	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , 
					new File("./reports/"+folder+"/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed."+e.getMessage());
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken"+e.getMessage());
		}
		return number;
	}

	@Override
	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","pass");
		} catch (Exception e) {
			reportStep("The browser could not be closed","fail");
		}
	}

	@Override
	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","pass");
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","fail");
		}
	}

}