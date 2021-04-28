package week3.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Disappearance {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement disappear = driver.findElementById("btn");
		System.out.println("Button text \""+disappear.getText()+"\"");
		wait.until(ExpectedConditions.invisibilityOf(disappear));
		System.out.println("Button is Displayed ? "+disappear.isDisplayed());
        driver.close();
	}

}
