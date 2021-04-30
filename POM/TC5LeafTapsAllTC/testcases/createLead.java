package TC5LeafTapsAllTC.testcases;

import TC4DataProviderExcel.base.ProjectSpecificMethods;
import TC4DataProviderExcel.pages.loginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class createLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setFileName() {
		excelFileName="CreateLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void cLead(String usrname, String password,String fName, String lName, String company) {
		System.out.println("***********CREATE LEAD************");
		new loginPage(driver).enterUsername(usrname).enterPassword(password).clickLoginButton()
		.clickCrmsfa().clickLeads().clickCreateLead()
		.enterFirstName(fName).enterLastName(lName).enterCompanyName(company).clickSubmitButton()
		.getTitle().getFirstName();
	}
}