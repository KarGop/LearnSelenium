package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class editLeadPage extends ProjectSpecificMethods {
	public editLeadPage (ChromeDriver driver) {
		this.driver=driver;
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
		return new viewLeadsPage(driver);
	}
}
