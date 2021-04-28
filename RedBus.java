package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//To Disable notifications pop up
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("src")).sendKeys("C");
		// Wait for the options to load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'All Locations')]")));
	    //Choose the second option
		driver.findElement(By.id("src")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElementById("dest").sendKeys("B");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'All Locations')]")));
		driver.findElementById("dest").sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		// Click on the field to open the calendar
		driver.findElement(By.id("onward_cal")).click();
		// Store the next button of the calendar
		WebElement next = driver.findElement(By.xpath("//td[@class='next']"));
		// Wait for the calendar to appear
		wait.until(ExpectedConditions.visibilityOf(next));
		// Click on next month
		next.click();
		System.out.println("Current page Title is '"+ driver.getTitle()+"'");
		System.out.println("We are in the month of "+driver.findElementByClassName("monthTitle").getText());
		// Select the day 1 of the month
		driver.findElementByXPath("(//td[contains(text(),1)])[2]").click();
		driver.findElementById("search_btn").click();
		// Close the icon loaded
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("close"))).click();
		//Print the number of search results
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='w-60 d-block d-found']")));
		System.out.println("No of search results : "+element.getText());
		//Choose only Sleeper Bus
		driver.findElementByXPath("(//input[@id='bt_SLEEPER']/following::label)[1]").click();
		// Get the number of buses found
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@title='SLEEPER']")));
		System.out.println("No of available Sleeper : "+driver.findElementByXPath("//span[@class='f-bold busFound']").getText());
		//Choose also AC buses
		driver.findElementByXPath("//input[@id='bt_AC']/following::label").click();
		// Get the number of buses found
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@title='AC']")));
		System.out.println("No of of AC Sleeper : "+driver.findElement(By.className("busFound")).getText());
		//Find the Bus name that is costly in the result shown
		List<WebElement> list = driver.findElementsByXPath("//span[@class='f-19 f-bold']");
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (WebElement eachcost : list) {
			String text = eachcost.getText();
			String textNums = text.replaceAll("[^0-9]", "");
			int cost_int = Integer.parseInt(textNums);
			arrayList.add(cost_int);
		}
		int max = Collections.max(arrayList);
		System.out.println("Maximum cost is "+max);
		System.out.println("Costliest Bus name :"+driver.findElementByXPath("//*[contains(text(),"+max+")]/preceding::div[@class=\"travels lh-24 f-bold d-color\"][1]").getText());
		int min = Collections.min(arrayList);
		System.out.println("Minimum cost is "+min);
		System.out.println("Budget Friendly Bus name :"+driver.findElementByXPath("//*[contains(text(),"+min+")]/preceding::div[@class=\"travels lh-24 f-bold d-color\"][1]").getText());	
	}
}