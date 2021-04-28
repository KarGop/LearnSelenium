package TC3ParameterPassingFromTCandXml.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import TC3ParameterPassingFromTCandXml.base.ProjectSpecificMethods;

public class createLeadPage extends ProjectSpecificMethods {
	public createLeadPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public createLeadPage enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;
	}
	public createLeadPage enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}
	public createLeadPage enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		return this;
}
	public viewLeadsPage clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
		return new viewLeadsPage(driver);
}
}