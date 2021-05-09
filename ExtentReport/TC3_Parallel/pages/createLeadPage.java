package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class createLeadPage extends ProjectSpecificMethods {
	public createLeadPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public createLeadPage enterFirstName(String firstName) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			reportStep("Entered First Name successfully","pass");
		} catch (Exception e) {
			reportStep("First Name is not entered successfully","fail");
		}
		return this;
	}
	public createLeadPage enterLastName(String lastName) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			reportStep("Entered last Name successfully","pass");
		} catch (Exception e) {
			reportStep("Last Name is not entered successfully","fail");
		}
		return this;
	}
	public createLeadPage enterCompanyName(String companyName) throws IOException {
		try {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
			reportStep("Entered company name successfully","pass");
		} catch (Exception e) {
			reportStep("Company Name is not entered successfully","fail");
		}
		return this;
}
	public viewLeadsPage clickSubmitButton() throws IOException {
		try {
			driver.findElement(By.name("submitButton")).click();
			reportStep("Create Lead Button clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Create Lead Button not clicked successfully","fail");
		}
		return new viewLeadsPage(driver, node);
}
}