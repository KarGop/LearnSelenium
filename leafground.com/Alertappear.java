package week3.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertappear {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();	  
		  @SuppressWarnings("deprecation")
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  driver.get("http://www.leafground.com/pages/alertappear.html");
		  driver.findElementById("alert").click();
		  wait.until(ExpectedConditions.alertIsPresent());
		  Alert alert = driver.switchTo().alert();
		  System.out.println("Alert text: \""+alert.getText()+"\""); 
		  alert.accept();
		  driver.close();	 
	}
}