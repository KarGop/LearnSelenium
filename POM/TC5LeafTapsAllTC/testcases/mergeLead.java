package TC5LeafTapsAllTC.testcases;

import TC5LeafTapsAllTC.base.ProjectSpecificMethods;
import TC5LeafTapsAllTC.pages.loginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mergeLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName() {
		excelFileName="MergeLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void mLead(String fromLead, String toLead) throws InterruptedException {
		System.out.println("***********MERGE LEAD************");
		new loginPage(driver).enterUsername("DemoSalesManager").enterPassword("crmsfa").clickLoginButton()
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