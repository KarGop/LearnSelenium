package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class editLeadPage extends ProjectSpecificMethods {
	public editLeadPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public viewLeadsPage updateCompanyName(String companyName) throws IOException {
		try {
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
			driver.findElement(By.name("submitButton")).click();
			reportStep("Company name is updated successfully","pass");
		} catch (Exception e) {
			reportStep("Company name is not updated successfully","fail");
		}
		return new viewLeadsPage(driver, node);
	}
}
