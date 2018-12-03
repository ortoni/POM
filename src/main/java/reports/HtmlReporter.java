package reports;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HtmlReporter {
@Test
	public void reports() throws IOException {
	// creates a blank html file
		ExtentHtmlReporter html = 
				new ExtentHtmlReporter("./reports/extentReport.html");
//		((Object) html).setAppendExisting(true); // -> to stop over write
		ExtentReports extent = new ExtentReports(); // creates a report
		// attach reports to the file
		extent.attachReporter(html);
		// create test with name and description
		ExtentTest test = extent.createTest("Login", "Login into leaftap");
		// assign author of the test case
		test.assignAuthor("koushik");
		// assign group of the test case
		test.assignCategory("smoke");
		// log steps of the test case
		test.pass("user name entered",
				MediaEntityBuilder
				.createScreenCaptureFromPath
				(".././snaps/dashboard.png").build());
		test.fail("user name is not entered",
				MediaEntityBuilder
				.createScreenCaptureFromPath(".././snaps/dashboard.png").build());
		extent.flush(); // save your file
	}

}







