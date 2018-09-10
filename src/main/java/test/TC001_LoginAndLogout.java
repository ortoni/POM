package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;

public class TC001_LoginAndLogout extends ProjectMethods {

	@BeforeTest
	public void setData() {
		testCaseName = "TC001_LoginAndLogout";
		testDescription ="login to leaftaps";
		category = "Smoke";
		authors= "sarath";
		testNodes = "Leads";
		dataSheetName="Login";
	}
	@Test(dataProvider="fetchData")
	public  void loginAndLogout(String uname, String password){
		new LoginPage()
		.typeUsername(uname)
		.typePassword(password)
		.clickLogin()
		.clickLogOut();
		
	}


}









