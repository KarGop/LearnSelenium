package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class myLeadsPage extends ProjectSpecificMethods {
	public myLeadsPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public createLeadPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			reportStep("Create Lead Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Create Lead Button is not clicked successfully","fail");
		}
		return new createLeadPage(driver, node);
	}
	public findLeadsPage clickFindLead() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Find Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Find Button is not clicked successfully","FAIL");
		}
		return new findLeadsPage(driver, node);
	}
	public mergeLeadsPage clickMergeLead() throws IOException {
		try {
			driver.findElement(By.linkText("Merge Leads")).click();
			reportStep("Merge Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Merge Button is not clicked successfully","fail");
		}
		return new mergeLeadsPage(driver, node);
	}
}
