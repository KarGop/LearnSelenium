package TC5LeafTapsAllTC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import TC5LeafTapsAllTC.base.ProjectSpecificMethods;

public class viewLeadsPage extends ProjectSpecificMethods {
	public viewLeadsPage (ChromeDriver driver) {
		this.driver=driver;
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
	public editLeadPage clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
		return new editLeadPage(driver);
	}
	public void verifyCompanyName(String companyName) {
		String company = driver.findElementByXPath("(//div[@class='fieldgroup-body']//span)[2]").getText();
		if(company.contains(companyName)) {
			System.out.println("Company Name is matched! ");
		}else {
			System.out.println("Now company name is" +company);
			System.out.println("Company Name is not updated Properly!");
	}}
	public myLeadsPage clickDelButton() {
		driver.findElement(By.linkText("Delete")).click();
		return new myLeadsPage(driver);
	}
	public duplicateLeadPage clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new duplicateLeadPage(driver);
	}
}