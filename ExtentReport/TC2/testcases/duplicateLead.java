package extentReports.TC2.testcases;

import extentReports.TC2.base.ProjectSpecificMethods;
import extentReports.TC2.pages.loginPage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class duplicateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setDetails() {
		excelFileName="DuplicateLead";
		testName ="Duplicate Lead";
		testDescription="Duplicate Lead..... ";
		testCategory="Functional";
		testAuthor="Karthi";
	}
	
	@Test(dataProvider = "fetchData")
	public void dupLead(String phNo) throws InterruptedException, IOException {
		System.out.println("***********DUPLICATE LEAD************");
		new loginPage(driver).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton()
		.clickCrmsfa()
		.clickLeads()
		.clickFindLead()
		.findByPhoneNo(phNo).clickFindLeadsButton().clickFirstRecord()
		.clickDuplicateLead()
		.clickCreateLead().getID();
	}
}