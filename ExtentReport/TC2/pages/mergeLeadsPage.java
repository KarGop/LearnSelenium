package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class mergeLeadsPage extends ProjectSpecificMethods {
	public mergeLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsWindow clickFromLeadLookup() throws IOException {
		try {
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			reportStep("Lookup is clicked successfully for getting 'From Lead'","pass");
		} catch (Exception e) {
			reportStep("Lookup is not clicked successfully for getting 'From Lead'","fail");
		}
		return new findLeadsWindow(driver);
	}
	public findLeadsWindow clickToLeadLookup() throws IOException {
		try {
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			reportStep("Lookup is clicked successfully for getting 'To Lead'","pass");
		} catch (Exception e) {
			reportStep("Lookup is not clicked successfully for getting 'To Lead'","fail");
		}
		return new findLeadsWindow(driver);
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
		return new myLeadsPage(driver);
	}
}