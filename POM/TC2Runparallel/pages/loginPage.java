package TC2Runparallel.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import TC2Runparallel.base.ProjectSpecificMethods;

public class loginPage extends ProjectSpecificMethods{
	
	public loginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public loginPage enterUsername() {
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		return this;
	}
	public loginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	public homePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		//homePage hp = new homePage();
		return new homePage(driver);
}	
}