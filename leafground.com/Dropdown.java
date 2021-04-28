package week2.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		System.out.println("Title is : "+ driver.getTitle());
		WebElement element1 = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(element1);
		dd1.selectByIndex(1);
		WebElement element2 = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(element2);
		dd2.selectByVisibleText("Appium");
		WebElement element3 = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(element3);
		dd3.selectByValue("4");
		System.out.println("Total no of dropdown : "+driver.findElements(By.xpath("//select[@class='dropdown']/option")).size());
		
		driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("UFT/QTP");
		WebElement element4 = driver.findElement(By.xpath("//div[@id=\"contentblock\"]/section/div[6]/select"));
		Select dd4 = new Select(element4);
		dd4.selectByVisibleText("Selenium");
		File screenshotsrc = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotsrc, new File ("./snap/dropdown.png"));
	}

}
