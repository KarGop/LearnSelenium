package TC2Runparallel.testcases;

import org.testng.annotations.Test;

import TC2Runparallel.base.ProjectSpecificMethods;
import TC2Runparallel.pages.loginPage;

public class createLead extends ProjectSpecificMethods {
	@Test
	public void cLead() {
		new loginPage(driver).enterUsername().enterPassword().clickLoginButton()
		.clickCrmsfa().clickLeads().clickCreateLead()
		.enterFirstName().enterLastName().enterCompanyName().clickSubmitButton()
		.getTitle().getFirstName();
	}
}