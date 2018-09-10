package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class TC004_DuplicateLead extends ProjectMethods {
	@BeforeClass(groups="common")
	public void setData() {
		testCaseName = "TC004_DuplicateLead";
		testDescription ="Duplicate a lead";
		category = "Smoke";
		authors= "Babu";
		testNodes = "Leads";
		dataSheetName="TC004";
	}
	@Test(dataProvider="fetchData")
	public  void duplicateLead(String email, String title) throws InterruptedException   {
		click(locateElement("linktext", "Leads"));
		click(locateElement("linktext", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Email']"));
		type(locateElement("name", "emailAddress"),email);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(1000);
		String leadName = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("linktext", "Duplicate Lead"));
		verifyTitle(title);
		click(locateElement("name", "submitButton"));
		WebElement eleVerify = locateElement("id", "viewLead_firstName_sp");
		verifyExactText(eleVerify, leadName);	
	}

}
