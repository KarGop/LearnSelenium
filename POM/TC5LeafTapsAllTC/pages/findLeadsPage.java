package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class findLeadsPage extends ProjectSpecificMethods{
	
	public findLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsPage findByPhoneNo(String phNumber) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNumber);
		return this;
	}
	public viewLeadsPage clickFirstRecord() throws InterruptedException {
		Thread.sleep(3000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		return new viewLeadsPage(driver);
	}
	public findLeadsPage findByID() {	
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		return this;
	}
	public findLeadsPage clickFindLeadsButton() {	
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public void verifyDelete() throws InterruptedException {
		Thread.sleep(2000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println(leadID+"is deleted...");
		} else {
			System.out.println(text);
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
