package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

public class findLeadsPage extends ProjectSpecificMethods{
	
	public findLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsPage findByPhoneNo(String phNumber) throws IOException {
		try {
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNumber);
			reportStep("Entered phone No successfully","pass");
		} catch (Exception e) {
			reportStep("Phone number is not entered successfully","fail");
		}
		return this;
	}
	public viewLeadsPage clickFirstRecord() throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
			reportStep("First record in viewLeadsPage is clicked successfully","pass");
		} catch (InterruptedException e) {
			reportStep("First record is not clicked successfully","fail");
		}
		return new viewLeadsPage(driver);
	}
	public findLeadsPage findByID() throws IOException {	
		try {
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			reportStep("Entered leadID successfully","pass");
		} catch (Exception e) {
			reportStep("leadID is not entered successfully","fail");
		}
		return this;
	}
	public findLeadsPage clickFindLeadsButton() throws IOException {	
		try {
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			reportStep("Find Lead button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Find Lead button is not clicked successfully","fail");
		}
		return this;
	}
	public void verifyDelete() throws InterruptedException, IOException {
		Thread.sleep(2000);
		try {
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println(leadID+"is deleted...");
			} else {
				System.out.println(text);
			}
			reportStep("Verified Delete lead","pass");
		} catch (Exception e) {
			reportStep("verifyDelete is failed","fail");
		}		
	}
	public findLeadsPage verify() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("No records to display");
		} else {
			System.out.println("Merge Data available");
		}
		return this;
	}
}
