package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;



public class ProjectMethods extends SeMethods {
	public String browserName;
	public String dataSheetName;

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeClass
	public void beforeClass(){		
		startTestModule(testCaseName, testDescription);	
	}
    @Parameters({"url"})
	@BeforeMethod
	public void beforeMethod(String URL){
		test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors);
		startApp("chrome", URL);
	}

	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterMethod
	public void afterMethod(){
		closeAllBrowsers();
	}

	@DataProvider(name="fetchData", indices = 0)
	public  Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}	


}


