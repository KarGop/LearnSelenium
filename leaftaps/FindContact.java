package week2.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByXPath("//a[text()='Find Contacts']").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByXPath("//input[@name=\"emailAddress\"]").sendKeys("welcome@gmail.com");
		driver.findElementByXPath("//button[text()='Find Contacts']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a").click();
		System.out.println("First Name is : "+driver.findElementById("viewContact_firstName_sp").getText());
		File file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,  new File ("./snap/FindContact"));
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		WebElement name1 = driver.findElementByName("marketingCampaignId");
		Select dd1 = new Select(name1);
		dd1.selectByValue("9000");
		driver.findElementByXPath("//input[@value='Add']").click();
		driver.findElementByName("departmentName").clear();
		driver.findElementByName("departmentName").sendKeys("Selenium Automation Testing");
		driver.findElementByXPath("//input[@value='Update']").click();
		File file1 = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1,  new File ("./snap/UpdatedContact"));
		String Mcampaign=driver.findElementById("viewContact_marketingCampaigns_sp").getText();
		System.out.println("Marketing Campaigns : "+ Mcampaign);
		System.out.println("Current page Title : "+ driver.getTitle());
		File file2 = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2,  new File ("./snap/ViewContact"));

	}

}
