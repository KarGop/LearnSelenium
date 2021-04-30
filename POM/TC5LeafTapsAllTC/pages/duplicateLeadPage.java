package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class duplicateLeadPage extends ProjectSpecificMethods {
	public duplicateLeadPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public viewLeadsPage clickCreateLead() {
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Original Lead ID: "+ leadID);
		return new viewLeadsPage(driver);
	}
}