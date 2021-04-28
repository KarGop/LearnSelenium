package TC1.pages;

import TC1.base.ProjectSpecificMethods;

public class logout extends ProjectSpecificMethods {
	public logout verifyTitle() {
		System.out.println("Page Title before Logout : "+driver.getTitle());
		return this;
	}
	public void logoutBeforecrmsfa(){
		driver.findElementByXPath("//input[@type=\"submit\"]").click();
		System.out.println("Page Title after Logout : "+driver.getTitle());
	}
}