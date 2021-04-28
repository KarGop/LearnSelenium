package TC1.testcases;

import org.testng.annotations.Test;

import TC1.base.ProjectSpecificMethods;
import TC1.pages.loginPage;

public class createLead extends ProjectSpecificMethods {
	@Test
	public void cLead() {
		new loginPage().enterUsername().enterPassword().clickLoginButton()
		.clickCrmsfa().clickLeads().clickCreateLead()
		.enterFirstName().enterLastName().enterCompanyName().clickSubmitButton()
		.getTitle().getFirstName();
	}
}