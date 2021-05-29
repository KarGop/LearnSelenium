package testNG.TC2Parameterization_DataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@Test(dataProvider ="fetchData")
	//(dataProvider = "sendData")
	public void runCreateLead(String companyName , String fName, String lName) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
}
	//Sending Dynamic data to runCreateLead
	@DataProvider(name ="fetchData")
	public String [][] sendData(){
		String data[] [] = new String [2] [3]; 
		data[0][0]="TL";
		data[0][1]="XXXXXX";
		data[0][2]="A";
		
		data[1][0]="TL";
		data[1][1]="YYYYYY";
		data[1][2]="B";
		return data;
	}
}