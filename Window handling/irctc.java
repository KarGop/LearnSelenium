package week4.day1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class irctc {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);		
		//Launch the URL 
		driver.get("https://www.irctc.co.in/");
		//Maximize browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		//Click OK button in the dialogue
		WebElement element = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
		actions.moveToElement(element);
		element.click();
		//Click on FLIGHTS link
		driver.findElement(By.xpath("//span[@class='allcircle circleone']")).click();
		System.out.println("Get WindowsHandles : ");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		for (String string : list) {
			System.out.println("\t"+string);
		}
		//Go to the Flights tab
		driver.switchTo().window(list.get(1));
		String irctcMail = driver.findElement(By.xpath("(//div[@class='block-nav-right']//a)[3]")).getText();
		System.out.println("CustomerCare Mail : "+irctcMail);
		//Close the First Tab(Train ticket booking) alone
		driver.switchTo().window(list.get(0)).close();
		
	}
}
