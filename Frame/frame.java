package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch the URL 
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//Maximize browser window
		driver.manage().window().maximize();
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//*[text()='Try it']").click();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		//Switch to Alert
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    System.out.println(driver.findElementById("demo").getText());
	    //Come out of the frame
	    driver.switchTo().defaultContent();
	}
}
