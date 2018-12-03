package answerConnect;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class A {
	public static void main(String[] args) throws IOException {
		 ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/reports.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(html);
			ExtentTest test = extent.createTest("Attach ScreenShot");
			// this does not through any error but snap is not attaching to reports.
			test.pass("Passed", 
	                MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/dashboard.png").build());
			// This attach the file in HTML but throwing exception as media not found
//			test.pass("Passed", MediaEntityBuilder.createScreenCaptureFromPath("./reports/dashboard.png").build());
			extent.flush();
	}

}
