package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class mergeLeadsPage extends ProjectSpecificMethods {
	public mergeLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsWindow clickFromLeadLookup() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		return new findLeadsWindow(driver);
	}
	public findLeadsWindow clickToLeadLookup() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		return new findLeadsWindow(driver);
	}
	public mergeLeadsPage clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		return this;
	}
	public myLeadsPage acceptAlert() {
		driver.switchTo().alert().accept();
		return new myLeadsPage(driver);
	}
}