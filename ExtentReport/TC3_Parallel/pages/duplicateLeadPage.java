package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class duplicateLeadPage extends ProjectSpecificMethods {
	public duplicateLeadPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public viewLeadsPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.name("submitButton")).click();
			System.out.println("Original Lead ID: "+ leadID);
			reportStep("Create Lead is clicked successfully for creating duplicate record","pass");
		} catch (Exception e) {
			reportStep("Create Lead is not clicked successfully for creating duplicate record","fail");
		}
		return new viewLeadsPage(driver, node);
	}
}