package TC3ParameterPassingFromTCandXml.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import TC3ParameterPassingFromTCandXml.base.ProjectSpecificMethods;

public class homePage extends ProjectSpecificMethods {
	public homePage (ChromeDriver driver) {
		this.driver=driver;
	}
	public myHomePage clickCrmsfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new myHomePage(driver);
	}
}