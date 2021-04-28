package TC1.pages;

import org.openqa.selenium.By;

import TC1.base.ProjectSpecificMethods;

public class homePage extends ProjectSpecificMethods {
	
	public myHomePage clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new myHomePage();
	}
}