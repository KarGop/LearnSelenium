package week2.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementByXPath("//label[text()='Username']/following-sibling::input").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@id=\"password\"]/following::input").click();
		//Click on CRMSFA link
		driver.findElementByXPath("//div[@id='label']/a").click();
		//Click on Leads link
		driver.findElementByXPath("//a[text()='Leads']").click();
		//Click on Merge Leads link
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		//Click the first img icon
		driver.findElementByXPath("(//img[@alt=\"Lookup\"])[1]").click();
		Thread.sleep(2000);
		//Moving to new window
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Naveen");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']").getText();
		driver.findElementByXPath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]").click();
		//Switch back to primary window
		driver.switchTo().window(list.get(0));
		//Click the second img icon
		driver.findElementByXPath("(//img[@alt=\"Lookup\"])[2]").click();
		Thread.sleep(2000);
		//Moving to new window
		ArrayList<String> win = new ArrayList<String>(driver.getWindowHandles());
		/*
		 * for (String string : list) { System.out.println("\t"+string); }
		 */
		driver.switchTo().window(win.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").click();
		//Switch back to primary window
		driver.switchTo().window(list.get(0));
		//Click on Merge Lead (submit) button
		driver.findElementByClassName("buttonDangerous").click();
		//Wait till alert thrown
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    System.out.println("Aler Message is '"+alert.getText()+"'");
	    // To click on the 'OK' button of the alert
	    alert.accept();
	    //Get the company name text based on its label
	    String name = driver.findElementById("viewLead_companyName_sp").getText();
	    System.out.println(name);
	    //name.replaceAll("\\D", "");
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snap/Leads.png"));
		//Click Find Leads link
		driver.findElementByXPath("//a[@href=\"/crmsfa/control/findLeads\"]").click();
		//Enter From Lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		//Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		driver.close();
	}
}
