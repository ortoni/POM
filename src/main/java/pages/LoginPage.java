package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    //changed by Gayatri
	@FindBy(id="username")
	WebElement eleUname;
	@Given("Enter username as (.*)")
	public LoginPage typeUsername(String data) {
		type(eleUname, data);
		return this;    
	}
	@FindBy(id="password")
	WebElement elePassword;
	@Given("Enter password as (.*)")
	public LoginPage typePassword(String data) {
		type(elePassword, data);
		return this;
	}
	@FindBy(className="decorativeSubmit")
	WebElement eleLogin;
	@When("Click login button")
	public HomePage clickLogin() {
		click(eleLogin);
		return new HomePage();		
	}
	@Then("verify that login is succesful")
	public LoginPage verifyLogin() {
	System.out.println("Verification logic");
		return this;

	}
}







