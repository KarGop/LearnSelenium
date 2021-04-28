package TC2Runparallel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import TC2Runparallel.base.ProjectSpecificMethods;

public class myLeadsPage extends ProjectSpecificMethods {
	public myLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public createLeadPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new createLeadPage(driver);
	}
}
