package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.testng.annotations.BeforeSuite;
import org.zeroturnaround.zip.ZipUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Report {
	public static String folder = "";
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest test, suiteTest;
	public String testCaseName, testNodes, testDescription, category, authors;
	@BeforeSuite
	public void startResult() {
		String now = LocalDateTime.now().toString();
		folder = now.replaceAll("\\D", "");
		File f = new File("./reports/"+folder);
		f.mkdirs();
		html = new ExtentHtmlReporter("./reports/"+folder+"/result.html");
		extent = new ExtentReports();		
		extent.attachReporter(html);	
	}
	//@AfterSuite
	public void zip() {
		System.out.println("zipping");
			ZipUtil.pack(new File("./reports/"+folder), new File("./reports/"+folder+".zip"));
	System.out.println("zip done");
	try {
		TriggerEmail.triggerEmail("./reports/"+folder+".zip");
	} catch (MessagingException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./images/"+snapNumber+".jpg").build();
			} catch (IOException e) {

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
