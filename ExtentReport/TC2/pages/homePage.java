package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class homePage extends ProjectSpecificMethods {
	public homePage (ChromeDriver driver) {
		this.driver=driver;
	}
	public myHomePage clickCrmsfa() throws IOException {
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("CRM/SFA link is clicked successfully","pass");
		} catch (Exception e) {
			
			reportStep("CRM/SFA link is not clicked  successfully","fail");
		}
		return new myHomePage(driver);
	}
}