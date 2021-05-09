package extentReports.TC2.pages;

import extentReports.TC2.base.ProjectSpecificMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage extends ProjectSpecificMethods{
	
	public loginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public loginPage enterUsername(String username) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(username);
			reportStep("Username "+username+" is entered successfully","pass");
		} catch (Exception e) {
			reportStep("Username is not entered successfully","fail");
		}
		return this;
	}
	public loginPage enterPassword(String pwd) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(pwd);
			reportStep("Password "+ pwd +"is entered successfully","pass");
		} catch (Exception e) {
			reportStep("Password is not entered successfully","fail");
		}
		return this;
	}
	@SuppressWarnings("finally")
	public homePage clickLoginButton() {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login Button is clicked successfully","pass");
		} 
		catch(Exception e) {
			reportStep("Login Button is not clicked successfully","fail");
		}
		finally {
			return new homePage(driver);
		}
}}