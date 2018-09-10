package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods {
    //Changed by koushik
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	@FindBy(className="decorativeSubmit")
	WebElement eleLogOut;
	@And("Click logout")
	public LoginPage clickLogOut() {
	click(eleLogOut);
	return new LoginPage();
	}
}







