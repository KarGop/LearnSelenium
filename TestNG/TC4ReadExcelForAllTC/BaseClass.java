package testNG.TC4ReadExcelForAllTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	public ChromeDriver driver;
	public String excelFileName;
	@Parameters({"url","username","pwd"})
	@BeforeClass
	
  public void preCondition(String url , String uName , String Password) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
  }
  @AfterClass
  public void postCondition() {
	  driver.close();
  } 
  @DataProvider(name ="fetchData")
	public String [][] sendData() throws IOException{
	  ReadExcel obj = new ReadExcel();
		return obj.excelRead(excelFileName);
}
  }