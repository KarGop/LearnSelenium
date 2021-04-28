package TC2Runparallel.pages;

import org.openqa.selenium.chrome.ChromeDriver;

import TC2Runparallel.base.ProjectSpecificMethods;

public class viewLeadsPage extends ProjectSpecificMethods {
	public viewLeadsPage (ChromeDriver driver) {
		this.driver=driver;
	}
	public viewLeadsPage getTitle() {
		System.out.println("Title of the current page is:"+driver.getTitle());
		return this;
	}
	public void getFirstName() {
		String fn = driver.findElementByXPath("//div[@class=\"fieldgroup-body\"]/table//tr[2]/td[2]").getText();
		System.out.println("First Name is "+fn);
	}
}
