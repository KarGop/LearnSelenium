package testNG.TC3ReadInputFromExcel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@Test(dataProvider ="fetchData")
	public void runCreateLead(String companyName , String fName, String lName) {
		System.out.println("Entered Create Lead .........");
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
}
	//Sending Dynamic data to runCreateLead
	@DataProvider(name ="fetchData")
	public String [][] sendData() throws IOException{
		ReadExcelCreateLead obj = new ReadExcelCreateLead();
		return obj.excelRead("CreateLead");
		//If a method in ReadExcelCreateLead is static, we no need to create object. Call using classname.methodname()
	}
}
