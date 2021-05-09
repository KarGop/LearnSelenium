package extentReports.TC2.testcases;

import extentReports.TC2.base.ProjectSpecificMethods;
import extentReports.TC2.pages.loginPage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setDetails() {
		excelFileName="DeleteLead";
		testName ="Delete Lead";
		testDescription="Delete Lead based on phone Number";
		testCategory="Functional";
		testAuthor="Karthi";
	}
	
	@Test(dataProvider = "fetchData")
	public void delLead(String phNo) throws InterruptedException, IOException {
		System.out.println("***********DELETE LEAD************");
		new loginPage(driver).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton()
		.clickCrmsfa()
		.clickLeads()
		.clickFindLead()
		.findByPhoneNo(phNo).clickFindLeadsButton().clickFirstRecord()
		.clickDelButton().clickFindLead().findByID().clickFindLeadsButton().verifyDelete();
	}
}