package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Report {
	static ExtentHtmlReporter html;
	static ExtentReports extent;
	public static ExtentTest test, suiteTest;
	public String testCaseName, testNodes, testDescription, category, authors;

	public void startResult() {
		html = new ExtentHtmlReporter("./reports/result.html");
		
		extent = new ExtentReports();		
		extent.attachReporter(html);	
	}


	public ExtentTest startTestModule(String testCaseName, String testDescription) {
		suiteTest = extent.createTest(testCaseName, testDescription);
		return suiteTest;
	}



	public ExtentTest startTestCase(String testNodes) {
		test = 	suiteTest.createNode(testNodes);
		return test;
	}

	public abstract long takeSnap();


	public void reportStep(String desc, String status, boolean bSnap)  {

		MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				File f = new File("./reports/"+snapNumber+".jpg");;
				System.out.println(f.getAbsolutePath());
				img = MediaEntityBuilder.createScreenCaptureFromPath
						(f.getAbsolutePath()).build();
			} catch (IOException e) {
				System.err.println(e.getMessage());

			}
		}
		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);			
		}else if (status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}else if (status.equalsIgnoreCase("WARNING")) {
			test.warning(desc, img);
		}else if (status.equalsIgnoreCase("INFO")) {
			test.info(desc);
		}						
	}


	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}




	public void endResult() {
		extent.flush();
	}	

}
