package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class myHomePage extends ProjectSpecificMethods{
	public myHomePage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
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
		return new myLeadsPage(driver, node);
}
}