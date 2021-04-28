package TC4DataProviderExcel.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import TC4DataProviderExcel.utils.ReadExcelCreateLead;

public class ProjectSpecificMethods {
	public ChromeDriver driver;
	public String excelFileName;
	
	@DataProvider(name ="fetchData")
	public String [][] sendData() throws IOException{	
		return ReadExcelCreateLead.excelRead(excelFileName);
	}		
		
	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}