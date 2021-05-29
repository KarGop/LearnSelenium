package testNG.TC1Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public ChromeDriver driver;
  @BeforeMethod
  public void preCondition() throws InterruptedException{
	  	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@href='/crmsfa/control/leadsMain']")).click();
		driver.findElement(By.linkText("Leads")).click();
  }
  @AfterMethod
  public void postCondition() {
	  driver.close();
  } 
}