package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");;
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ZOHO");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Karthi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Gopal");
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1=new Select(source);
		dd1.selectByVisibleText("Employee");
		WebElement marketing_compaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd2 =new Select(marketing_compaign);
		dd2.selectByValue("CATRQ_CARNDRIVER");
		driver.findElementByClassName("smallSubmit").click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		
	}
}