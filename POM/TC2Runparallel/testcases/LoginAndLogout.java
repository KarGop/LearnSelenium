package TC2Runparallel.testcases;

import org.testng.annotations.Test;

import TC2Runparallel.base.ProjectSpecificMethods;
import TC2Runparallel.pages.loginPage;

public class LoginAndLogout extends ProjectSpecificMethods{
	@Test
	public void loginAndLogout() {
		
		new loginPage(driver).enterUsername().enterPassword().clickLoginButton().clickCrmsfa()
		.verifyTitle().logoutFromHomePage();
	}
}
