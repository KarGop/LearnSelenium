package extentReports.TC1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

public static void main(String[] args) throws IOException {
	
	//setup the path for report
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./src/main/java/extentReports/report/result.html");
	//To maintain the history of execution
	reporter.setAppendExisting(true);
	//class to capture the data for the report
	ExtentReports extent = new ExtentReports();
	//to integrate physical report with actual data
	extent.attachReporter(reporter);
	
	//create atTest with name and description
	ExtentTest test = extent.createTest("LoginAndLogout", "Login with Positive Data");
	//Adding category and author info to test case
	test.assignCategory("Functional");
	test.assignAuthor("Karthi");
	
	//test step level status
	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	System.out.println("Current relative path is: " + s);
	test.pass("Enter Username", MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img11895.png").build());
	test.pass("Enter Password");
	test.pass("Click Login Button");
	//test.fail("Click Login Button");
	
	//mandatory step
	extent.flush();
	System.out.println("Report is Ready!!!");
 }
}
