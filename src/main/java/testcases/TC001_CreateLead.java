package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class TC001_CreateLead extends ProjectMethods {

	@BeforeTest(groups="common")
	public void setData() {
		testCaseName = "TC001_CreateLead";
		testDescription ="Create a lead";
		category = "Smoke";
		authors= "sarath";
		testNodes = "Leads";
		dataSheetName="TC001";
	}
	@Test(dataProvider="fetchData")
	public  void createLead(String cname, String fname, String lname, String email)   {

		click(locateElement("linktext", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cname);
		type(locateElement("id", "createLeadForm_firstName"), fname);
		type(locateElement("id", "createLeadForm_lastName"), lname);
		type(locateElement("id", "createLeadForm_primaryEmail"), email); 
		click(locateElement("name", "submitButton"));
	}


}
