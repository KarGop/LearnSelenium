package extentReports.TC3_Parallel.testcases;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;
import extentReports.TC3_Parallel.pages.loginPage;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mergeLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setDetails() {
		excelFileName="MergeLead";
		testName ="Merge Lead";
		testDescription="Merge two Lead's";
		testCategory="Functional";
		testAuthor="Karthi";
	}
	
	@Test(dataProvider = "fetchData")
	public void mergLead(String fromLead, String toLead) throws InterruptedException, IOException {
		System.out.println("***********MERGE LEAD************");
		new loginPage(driver, node).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton()
		.clickCrmsfa()
		.clickLeads()
		.clickMergeLead()
		.clickFromLeadLookup()
		.switchFindLeadsWindow().enterFirstName(fromLead).clickFindLeadsButton()
		.clickFirstRecord()
		.switchPrimaryWindow()
		.clickToLeadLookup()
		.switchFindLeadsWindow().enterFirstName(toLead).clickFindLeadsButton()
		.clickFirstRecord().switchPrimaryWindow()
		.clickMergeButton().acceptAlert()
		.clickFindLead().findByID().clickFindLeadsButton().verify().clickFirstRecord().getID();	
	}
}