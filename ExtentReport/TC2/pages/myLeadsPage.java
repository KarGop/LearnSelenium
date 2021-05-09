package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class myLeadsPage extends ProjectSpecificMethods {
	public myLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public createLeadPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Create Lead")).click();
			reportStep("Create Lead Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Create Lead Button is not clicked successfully","fail");
		}
		return new createLeadPage(driver);
	}
	public findLeadsPage clickFindLead() throws IOException {
		try {
			driver.findElement(By.linkText("Find Leads")).click();
			reportStep("Find Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Find Button is not clicked successfully","FAIL");
		}
		return new findLeadsPage(driver);
	}
	public mergeLeadsPage clickMergeLead() throws IOException {
		try {
			driver.findElement(By.linkText("Merge Leads")).click();
			reportStep("Merge Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Merge Button is not clicked successfully","fail");
		}
		return new mergeLeadsPage(driver);
	}
}
