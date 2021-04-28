package TC1.pages;

import org.openqa.selenium.By;

import TC1.base.ProjectSpecificMethods;

public class myLeadsPage extends ProjectSpecificMethods {
	
	public createLeadPage clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		return new createLeadPage();
	}
}
