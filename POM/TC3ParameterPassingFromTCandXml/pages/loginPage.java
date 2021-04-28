package TC3ParameterPassingFromTCandXml.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import TC3ParameterPassingFromTCandXml.base.ProjectSpecificMethods;

public class loginPage extends ProjectSpecificMethods{
	
	public loginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public loginPage enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		return this;
	}
	public loginPage enterPassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
		return this;
	}
	public homePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		return new homePage(driver);
}	
}