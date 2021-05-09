package extentReports.TC3_Parallel.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import extentReports.TC3_Parallel.utils.ReadExcelCreateLead;

public class ProjectSpecificMethods {
	public ChromeDriver driver;
	public String excelFileName;
	public static String leadID;
	public static List<String> allhandles;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test, node;
	public String testName,testDescription,testCategory,testAuthor;
	
	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 99999);		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, target);
		System.out.println(ranNum);
		return ranNum;
	}	
			
	public void reportStep(String msg, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath("/home/karthika/eclipse-workspace/PageObjectModel/snaps/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail")) {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath("/home/karthika/eclipse-workspace/PageObjectModel/snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException();
		}
	}
	
	@BeforeSuite
	public void startReport() {
		//setup the path for report
		reporter = new ExtentHtmlReporter("./src/main/java/extentReports/report/ParallelResults.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		//Adding category and author info to test case
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
	}	
	
	@DataProvider(name ="fetchData", indices =0)
	public String [][] sendData() throws IOException{	
		return ReadExcelCreateLead.excelRead(excelFileName);
	}		
	
	@BeforeMethod
	public void preCondition() {
		//createNode is the subset of the test. It will create a node for each set of data
		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
		System.out.println("Report is Ready!!!");
	}
}