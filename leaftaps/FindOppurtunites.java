package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOppurtunites {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		 driver.get("http://leaftaps.com/opentaps/control/login");
		//Enter UserName and Password Using Xpath Locator
		 driver.findElementByXPath("(//input[@name=\"USERNAME\"])[1]").sendKeys("DemoCSR");
		 driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		//Click on Login Button using Xpath Locator
        driver.findElementByXPath("//input[@value='Login']").click();
		//Click on CRM/SFA Link
		 driver.findElementByXPath("//a[contains(text(),'CRM')]").click();
		//Click on Opportunities Button
		 driver.findElementByLinkText("Opportunities").click();
		//Click on Find Opportunities using Xpath Locator
		 driver.findElementByXPath("//a[text()='Find Opportunities']").click();
		//Get the List of Opportunities available in Opportunity id using Xpath Locator
		 System.out.println("List of Opportunities are ...");
		 List<WebElement>  OpportunityId = driver.findElementsByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-salesOpportunityId']");
		 for (WebElement eachOpportunity : OpportunityId) {
			System.out.println("\t"+eachOpportunity.getText());
		}
		//Get the Title of the Page and verify it.
        System.out.println("Title of the current page is : " + driver.getTitle());  
	}

}
