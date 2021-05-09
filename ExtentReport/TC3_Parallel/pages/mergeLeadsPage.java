package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class mergeLeadsPage extends ProjectSpecificMethods {
	public mergeLeadsPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public findLeadsWindow clickFromLeadLookup() throws IOException {
		try {
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			reportStep("Lookup is clicked successfully for getting 'From Lead'","pass");
		} catch (Exception e) {
			reportStep("Lookup is not clicked successfully for getting 'From Lead'","fail");
		}
		return new findLeadsWindow(driver, node);
	}
	public findLeadsWindow clickToLeadLookup() throws IOException {
		try {
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			reportStep("Lookup is clicked successfully for getting 'To Lead'","pass");
		} catch (Exception e) {
			reportStep("Lookup is not clicked successfully for getting 'To Lead'","fail");
		}
		return new findLeadsWindow(driver, node);
	}
	public mergeLeadsPage clickMergeButton() throws IOException {
		try {
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
			reportStep("Merge Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Merge Button is not clicked successfully","fail");
		}
		return this;
	}
	public myLeadsPage acceptAlert() {
		driver.switchTo().alert().accept();
		return new myLeadsPage(driver, node);
	}
}