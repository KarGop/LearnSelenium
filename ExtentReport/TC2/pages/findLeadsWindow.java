package extentReports.TC2.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class findLeadsWindow extends ProjectSpecificMethods {
	public findLeadsWindow (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsWindow switchFindLeadsWindow() throws IOException {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			allhandles = new ArrayList<String>(allWindows);
			driver.switchTo().window(allhandles.get(1));
			reportStep("Moved to new window successfully","pass");
		} catch (Exception e) {
			reportStep("driver is not moved to new window","fail");
		}
		return this;
	}
	public findLeadsWindow enterFirstName(String name) throws IOException {
		try {
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(name);
			reportStep("Entered First name successfully","pass");
		} catch (Exception e) {
			
			reportStep("First name is not entered successfully","fail");
		}
		return this;
	}
	public findLeadsWindow clickFindLeadsButton() throws IOException {
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Find lead Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("find lead Button is not clicked successfully","fail");
		}
		return this;
	}
	public findLeadsWindow clickFirstRecord() throws InterruptedException, IOException {
		Thread.sleep(2000);
		try {
			leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			System.out.println("lead ID is "+leadID);
			reportStep("First record is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("first record is not clicked successfully","fail");
		}
		return this;
	}
	public mergeLeadsPage switchPrimaryWindow() throws IOException {
		try {
			driver.switchTo().window(allhandles.get(0));
			reportStep("Switch Back to Primary window","pass");
		} catch (Exception e) {
			reportStep("Couln't move to Primary window","fail");
		}
		return new mergeLeadsPage(driver);
	}
	
	
}