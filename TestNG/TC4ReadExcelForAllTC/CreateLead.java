package testNG.TC4ReadExcelForAllTC;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	@BeforeTest
	public void setFileName() {
		excelFileName="CreateLead";
	}
	
	@Test(dataProvider ="fetchData")
	public void runCreateLead(String companyName , String fName, String lName) {
		System.out.println("Entered Create Lead .........");
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
}
}
