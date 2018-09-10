package testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class TC003_DeleteLead extends ProjectMethods {
	@BeforeClass(groups="common")
	public void setData() {
		testCaseName = "TC003_DeleteLead";
		testDescription ="Delete a lead";
		category = "Smoke";
		authors= "Babu";
		testNodes = "Leads";
		dataSheetName="TC003";
	}
	@Test(dataProvider="fetchData")
	public  void deleteLead(String email, String errorMsg) throws InterruptedException   {
		click(locateElement("linktext", "Leads"));
		click(locateElement("linktext", "Find Leads"));
		click(locateElement("xpath", "//span[text()='Email']"));
		type(locateElement("name", "emailAddress"),email);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(1000);
		String leadId = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("linktext", "Delete"));
				
		click(locateElement("linktext", "Find Leads"));
		type(locateElement("name", "id"),leadId);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(1000);
		WebElement eleVerify = locateElement("class", "x-paging-info");
		verifyExactText(eleVerify, errorMsg);
	
	}

}
