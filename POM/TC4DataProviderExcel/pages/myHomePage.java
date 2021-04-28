package TC4DataProviderExcel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC4DataProviderExcel.base.ProjectSpecificMethods;

public class myHomePage extends ProjectSpecificMethods{
	public myHomePage (ChromeDriver driver) {
		this.driver=driver;
	}
	public myHomePage verifyTitle() {
		System.out.println("Page Title before Logout : "+driver.getTitle());
		return this;
	}
	public void logoutFromHomePage(){
		driver.findElementByXPath("//a[text()='Logout']").click();
		System.out.println("Page Title after Logout : "+driver.getTitle());
	}
	public myLeadsPage clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
		return new myLeadsPage(driver);
}
}