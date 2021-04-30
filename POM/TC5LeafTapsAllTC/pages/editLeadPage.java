package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class editLeadPage extends ProjectSpecificMethods {
	public editLeadPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public viewLeadsPage updateCompanyName(String companyName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.name("submitButton")).click();
		return new viewLeadsPage(driver);
	}
}
