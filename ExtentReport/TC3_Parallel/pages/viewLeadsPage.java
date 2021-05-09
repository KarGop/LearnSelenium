package extentReports.TC3_Parallel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

public class viewLeadsPage extends ProjectSpecificMethods {
	public viewLeadsPage (ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
	}
	public viewLeadsPage getTitle() {
		System.out.println("Title of the current page is:"+driver.getTitle());
		return this;
	}
	public void getFirstName() {
		String fn = driver.findElementByXPath("//div[@class=\"fieldgroup-body\"]/table//tr[2]/td[2]").getText();
		System.out.println("First Name is : "+fn);
	}
	public void getID() {
		String company = driver.findElementById("viewLead_companyName_sp").getText();
		String ID = company.replaceAll("\\D", "");
		System.out.println("New Lead ID is "+ ID);
	}
	public editLeadPage clickEditButton() throws IOException {
		try {
			driver.findElement(By.linkText("Edit")).click();
			reportStep("Edit Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Edit Button is not clicked successfully","fail");
		}
		return new editLeadPage(driver, node);
	}
	public void verifyCompanyName(String companyName) {
		String company = driver.findElementByXPath("(//div[@class='fieldgroup-body']//span)[2]").getText();
		if(company.contains(companyName)) {
			System.out.println("Company Name is matched! ");
		}else {
			System.out.println("Now company name is" +company);
			System.out.println("Company Name is not updated Properly!");
	}}
	public myLeadsPage clickDelButton() throws IOException {
		try {
			driver.findElement(By.linkText("Delete")).click();
			reportStep("Delete Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Delete Button is not clicked successfully","fail");
		}
		return new myLeadsPage(driver, node);
	}
	public duplicateLeadPage clickDuplicateLead() throws IOException {
		try {
			driver.findElement(By.linkText("Duplicate Lead")).click();
			reportStep("Duplicate Lead Button is clicked successfully","pass");
		} catch (Exception e) {
			reportStep("Duplicate Lead Button is not clicked successfully","fail");
		}
		return new duplicateLeadPage(driver, node);
	}
}