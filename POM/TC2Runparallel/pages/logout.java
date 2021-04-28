package TC2Runparallel.pages;

import org.openqa.selenium.chrome.ChromeDriver;

import TC2Runparallel.base.ProjectSpecificMethods;

public class logout extends ProjectSpecificMethods {
	public logout (ChromeDriver driver) {
		this.driver=driver;
	}
	public logout verifyTitle() {
		System.out.println("Page Title before Logout : "+driver.getTitle());
		return this;
	}
	public void logoutBeforecrmsfa(){
		driver.findElementByXPath("//input[@type=\"submit\"]").click();
		System.out.println("Page Title after Logout : "+driver.getTitle());
	}
}