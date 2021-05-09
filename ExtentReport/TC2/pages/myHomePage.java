package extentReports.TC2.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import extentReports.TC2.base.ProjectSpecificMethods;

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
	public myLeadsPage clickLeads() throws IOException {
		try {
			driver.findElement(By.linkText("Leads")).click();
			reportStep("Leads Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Leads Button is not clicked successfully","fail");
		}
		return new myLeadsPage(driver);
}
}