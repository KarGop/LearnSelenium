package TC5LeafTapsAllTC.pages;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class findLeadsWindow extends ProjectSpecificMethods {
	public findLeadsWindow (ChromeDriver driver) {
		this.driver=driver;
	}
	public findLeadsWindow switchFindLeadsWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		return this;
	}
	public findLeadsWindow enterFirstName(String name) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(name);
		return this;
	}
	public findLeadsWindow clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		return this;
	}
	public findLeadsWindow clickFirstRecord() throws InterruptedException {
		Thread.sleep(3000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		System.out.println("lead ID is "+leadID);
		return this;
	}
	public mergeLeadsPage switchPrimaryWindow() {
		driver.switchTo().window(allhandles.get(0));
		return new mergeLeadsPage(driver);
	}
	
	
}