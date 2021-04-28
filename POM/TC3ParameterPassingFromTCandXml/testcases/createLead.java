package TC3ParameterPassingFromTCandXml.testcases;

import org.testng.annotations.Test;

import TC3ParameterPassingFromTCandXml.base.ProjectSpecificMethods;
import TC3ParameterPassingFromTCandXml.pages.loginPage;

public class createLead extends ProjectSpecificMethods {
	@Test
	public void cLead() {
		new loginPage(driver).enterUsername("DemoCSR").enterPassword("crmsfa").clickLoginButton()
		.clickCrmsfa().clickLeads().clickCreateLead()
		.enterFirstName("KaRtHi").enterLastName("A").enterCompanyName("Test").clickSubmitButton()
		.getTitle().getFirstName();
	}
}