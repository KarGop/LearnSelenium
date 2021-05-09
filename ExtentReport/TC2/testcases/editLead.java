package extentReports.TC2.testcases;

import extentReports.TC2.base.ProjectSpecificMethods;
import extentReports.TC2.pages.loginPage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class editLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setDetails() {
		excelFileName="EditLead";
		testName ="Edit Lead";
		testDescription="Edit company name";
		testCategory="Functional";
		testAuthor="Karthi";
	}
	
	@Test(dataProvider = "fetchData")
	public void editLd(String phNo, String company) throws IOException, InterruptedException {
		System.out.println("***********EDIT LEAD************");
		new loginPage(driver).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton()
		.clickCrmsfa()
		.clickLeads()
		.clickFindLead()
		.findByPhoneNo(phNo).clickFindLeadsButton().clickFirstRecord()
		.clickEditButton()
		.updateCompanyName(company)
		.verifyCompanyName(company);
	}
}