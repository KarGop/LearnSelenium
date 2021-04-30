package TC5LeafTapsAllTC.testcases;

import TC5LeafTapsAllTC.base.ProjectSpecificMethods;
import TC5LeafTapsAllTC.pages.loginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class duplicateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName() {
		excelFileName="DuplicateLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void dupLead(String phNo) throws InterruptedException {
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