package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class myLeadsPage extends ProjectSpecificMethods {
	public myLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public createLeadPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new createLeadPage(driver);
	}
	public findLeadsPage clickFindLead() {
		driver.findElement(By.linkText("Find Leads")).click();
		return new findLeadsPage(driver);
	}
	public mergeLeadsPage clickMergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new mergeLeadsPage(driver);
	}
}
