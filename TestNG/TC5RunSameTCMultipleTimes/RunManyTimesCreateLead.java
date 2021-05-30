package testNG.TC5RunSameTCMultipleTimes;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RunManyTimesCreateLead extends BaseClass{
	
	@Test(invocationCount=3)
	public void runCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		driver.findElement(By.name("submitButton")).click();
}
}