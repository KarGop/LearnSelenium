package TC1.pages;
import org.openqa.selenium.By;

import TC1.base.ProjectSpecificMethods;

public class loginPage extends ProjectSpecificMethods{
	
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
		return new homePage();
}	
}