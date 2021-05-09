package extentReports.TC2.testcases;

import extentReports.TC2.base.ProjectSpecificMethods;
import extentReports.TC2.pages.loginPage;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class createLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setDetails() {
		excelFileName="CreateLead";
		testName ="Create Lead";
		testDescription="Create Lead with mandatory details";
		testCategory="Functional";
		testAuthor="Karthi";
	}
	
	@Test(dataProvider = "fetchData")
	public void cLead(String usrname, String password,String fName, String lName, String company) throws IOException {
		System.out.println("***********CREATE LEAD************");
		new loginPage(driver).enterUsername(usrname).enterPassword(password).clickLoginButton()
		.clickCrmsfa().clickLeads().clickCreateLead()
		.enterFirstName(fName).enterLastName(lName).enterCompanyName(company).clickSubmitButton()
		.getTitle().getFirstName();
	}
}