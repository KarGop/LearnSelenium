package testNG.TC1Basic;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	@Test
	public void runCreateLead() {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.get("http://leaftaps.com/opentaps/");
		 * //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		 * driver.findElement(By.id("password")).sendKeys("crmsfa");
		 * driver.findElement(By.className("decorativeSubmit")).click();
		 * driver.findElement(By.linkText("CRM/SFA")).click();
		 * driver.findElement(By.linkText("Leads")).click();
		 */
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.name("submitButton")).click();
		//driver.close();
}
}