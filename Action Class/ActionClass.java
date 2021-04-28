package week4.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch the URL 
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//Maximize browser window
		driver.manage().window().maximize();
		WebElement option1 = driver.findElementByXPath("//option[text()='Select your programs']/following-sibling::option[1]");
		WebElement option4 = driver.findElementByXPath("//option[text()='Select your programs']/following-sibling::option[4]");
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(option1).click(option4).keyUp(Keys.CONTROL).perform();		
	}
}