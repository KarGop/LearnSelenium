package extentReports.TC3_Parallel.pages;

import extentReports.TC3_Parallel.base.ProjectSpecificMethods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public class loginPage extends ProjectSpecificMethods{
	
	public loginPage(ChromeDriver driver,ExtentTest node) {
		this.driver=driver;
		this.node=node;
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
			return new homePage(driver, node);
		}
}}