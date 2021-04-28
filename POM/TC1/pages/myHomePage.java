package TC1.pages;

import org.openqa.selenium.By;

import TC1.base.ProjectSpecificMethods;

public class myHomePage extends ProjectSpecificMethods{
	
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
		return new myLeadsPage();
}
}