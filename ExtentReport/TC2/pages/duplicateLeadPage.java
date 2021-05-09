package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class duplicateLeadPage extends ProjectSpecificMethods {
	public duplicateLeadPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public viewLeadsPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.name("submitButton")).click();
			System.out.println("Original Lead ID: "+ leadID);
			reportStep("Create Lead is clicked successfully for creating duplicate record","pass");
		} catch (Exception e) {
			reportStep("Create Lead is not clicked successfully for creating duplicate record","fail");
		}
		return new viewLeadsPage(driver);
	}
}