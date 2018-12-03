package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;



public class ProjectMethods extends SeMethods {
	public String browserName;
	public String dataSheetName;
	
	@BeforeClass
	public void beforeClass(){		
		startTestModule(testCaseName, testDescription);	
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("");
		test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors);
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		type(locateElement("id", "username"), 
				"DemoSalesManager");
		type(locateElement("id", "password"),"crmsfa");
		locateElement("class", "decorativeSubmit").submit();
		locateElement("linktext", "CRM/SFA");
	}

	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterMethod
	public void afterMethod(){
		closeAllBrowsers();
	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return DataInputProvider.getSheet("TC001");		
	}	


}


