package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.leafground.com/pages/appear.html");
        // maximize the browser window
        driver.manage().window().maximize();
        @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn")));
        System.out.println("Latest appear button text : "+element.getText());
        driver.close();
		
	}
}