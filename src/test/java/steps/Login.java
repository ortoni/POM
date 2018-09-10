/*package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
public ChromeDriver driver;
  @Given("Launch the browser")
	public void launchBrowser() {
	driver = new ChromeDriver();
	}
  @And("Maximize the browser")
	public void maximize() {
	driver.manage().window().maximize();	
	}
  @And("Set timeout")
	public void timeOut() {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
  @And("Load the URL")
	public void loadURL() {
	driver.get("http://leaftaps.com/opentaps/control/main");
	}
  
  
  @Then("verify that login is success")
  public void verifyThatLoginIsSuccess() {
      // Write code here that turns the phrase above into concrete actions
      //throw new PendingException();
  }
  @Given("Enter username as (.*)")
	public void typeUsernameForDemoSalesManager(String uName) {
	driver.findElementById("username").sendKeys(uName);	
	}
  @And("Enter password as (.*)")
	public void typePassword(String pwd) {
	driver.findElementById("password").sendKeys(pwd);	
	}
  @And("Enter username as DemoSCR")
	public void typeUsernameForDemoCSR() {
	driver.findElementById("username").sendKeys("DemoCSR");	
	}
  @When("Click login button")
	public void clickLogin() {
	driver.findElementByClassName("decorativeSubmit").click();	
	}
  @Then("verify that login is successful")
  public void verify() {
	  System.out.println("verified");
  }
  @But("login should fail")
  public void negativeLogin() {
	  System.out.println("Failed");
  }
}*/