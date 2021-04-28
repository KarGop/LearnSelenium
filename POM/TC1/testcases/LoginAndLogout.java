package TC1.testcases;

import org.testng.annotations.Test;

import TC1.base.ProjectSpecificMethods;
import TC1.pages.loginPage;


public class LoginAndLogout extends ProjectSpecificMethods{
	@Test
	public void loginAndLogout() {		
		new loginPage().enterUsername().enterPassword().clickLoginButton().clickCrmsfa()
		.verifyTitle().logoutFromHomePage();
	}
}
