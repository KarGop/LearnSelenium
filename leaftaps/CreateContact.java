package week2.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("Karthi");
		driver.findElementById("lastNameField").sendKeys("A");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Kar");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("AA");
		driver.findElementByName("departmentName").sendKeys("XYYZZZ");
		driver.findElementById("createContactForm_description").sendKeys("QWERTY");
		driver.findElementByXPath("(//td[@colspan='4']/input)[3]").sendKeys("welcome@gmail.com");;
		WebElement element = driver.findElementByCssSelector("select[name=generalStateProvinceGeoId]");
		Select dd1 = new Select(element);
		dd1.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		File file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File ("./snap/createContact.png"));
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementById("updateContactForm_description").clear();
		driver.findElementByName("importantNote").sendKeys("VERY IMPORTANT");
		driver.findElementByXPath("(//input[@name=\"submitButton\"])[1]").click();
		System.out.println("Current page Title : "+ driver.getTitle());
		File file1= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("./snap/UpdateContact.png"));
	}

}
