package TC1.pages;

import org.openqa.selenium.By;

import TC1.base.ProjectSpecificMethods;

public class createLeadPage extends ProjectSpecificMethods {
	
	public createLeadPage enterFirstName() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthi");
		return this;
	}
	public createLeadPage enterLastName() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		return this;
	}
	public createLeadPage enterCompanyName() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		return this;
}
	public viewLeadsPage clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
		return new viewLeadsPage();
}
}