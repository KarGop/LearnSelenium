package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class homePage extends ProjectSpecificMethods {
	public homePage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public myHomePage clickCrmsfa() throws IOException {
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("CRM/SFA link is clicked successfully","pass");
		} catch (Exception e) {
			
			reportStep("CRM/SFA link is not clicked  successfully","fail");
		}
		return new myHomePage(driver, node);
	}
}