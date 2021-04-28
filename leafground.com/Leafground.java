package week2.day1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {

	public static void main(String[] args) {
		System.out.println("URLS are \n 1.http://leafground.com/ \n" + "2.http://leafground.com/pages/Edit.html\n 3.http://leafground.com/pages/Button.html \n 4.http://leafground.com/pages/Link.html \n5.http://leafground.com/pages/checkbox.html \n");
		System.out.println("Enter the case which you want to perform...");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		switch(num) {
		case 1:
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leafground.com/");
			System.out.println("Title is : "+ driver.getTitle());
			if(driver.getTitle().contains("TestLeaf")) {
				System.out.println("The title of the given URL has the word TestLeaf");			
			}
			else
				System.out.println("The title doesn't have the word TestLeaf");
			System.out.println("URL is : "+ driver.getCurrentUrl());
			//System.out.println("The source code is " + driver.getPageSource());
			//driver.close();
			break;
		case 2:
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver2=new ChromeDriver();
			driver2.get("http://leafground.com/pages/Edit.html");
			driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver2.manage().window().maximize();
			driver2.findElement(By.id("email")).sendKeys("Testleaf_learner@gmail.com");
			driver2.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys("Done!!!");
			String txt = driver2.findElementByName("username").getAttribute("value");
			System.out.println("Default text is : "+ txt);
			System.out.println("isEnabled: "+driver2.findElementByName("username").isEnabled());
			System.out.println("isEnabled: "+driver2.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input").isEnabled());
			driver2.findElementByXPath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input").clear();
			//driver2.close();
			break;
		case 3:
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver3=new ChromeDriver();
			driver3.get("http://leafground.com/pages/Button.html");
			driver3.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver3.manage().window().maximize();
			System.out.println("X Position: "+driver3.findElementById("position").getLocation().getX());
			System.out.println("Y Position: "+driver3.findElementById("position").getLocation().getY());
			System.out.println("x&y Position: "+driver3.findElementById("position").getLocation());
			System.out.println("Get text : "+driver3.findElementById("color").getText());
			System.out.println("Background color of a button : "+driver3.findElementById("color").getCssValue("background-color"));
			System.out.println("Height "+driver3.findElementById("size").getSize().getHeight());
			System.out.println("Width "+driver3.findElementById("size").getSize().getWidth());
			System.out.println("Size "+driver3.findElementById("size").getSize());
			System.out.println("Tag name : "+driver3.findElementById("color").getTagName());
			System.out.println("isDisplayed "+driver3.findElementById("color").isDisplayed());
			System.out.println("Current title is : "+ driver3.getTitle());
			driver3.findElementById("home").click();
			System.out.println("Now the Current title is : "+ driver3.getTitle());
			break;
		case 4:
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver4=new ChromeDriver();
			driver4.get("http://leafground.com/pages/Link.html");
			driver4.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver4.manage().window().maximize();
			System.out.println("Get URL without clicking  : "+driver4.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href"));
			System.out.println("Current title is : "+ driver4.getTitle());
			driver4.findElementByLinkText("Go to Home Page").click();
			System.out.println("Now the Current title is : "+ driver4.getTitle());
			break;
		case 5:
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver5=new ChromeDriver();
			driver5.get("http://leafground.com/pages/checkbox.html");
			driver5.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver5.manage().window().maximize();
			System.out.println("isSelected : "+driver5.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/label").isSelected());
			System.out.println("isSelected : "+driver5.findElementByXPath("//*[@id=\"contentblock\"]/section/div[1]/div[1]").isSelected());
			
			break;
		default:
	        System.out.println("Invalid !");
	        break;
		}
	}

}
