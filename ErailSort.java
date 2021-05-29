package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
		//Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		//Uncheck the check box - sort on date
		driver.findElementById("chkSelectDateOnly").click();;
		//WebElement check box = driver.findElementByXPath("//*[contains(text(),'Sort on Date')]/following-sibling::input");
		//System.out.println("Check box is selected ? "+checkbox.isSelected());
		//clear and Enter the from city and do Tab
		WebElement src = driver.findElementById("txtStationFrom");
		src.clear();
		src.sendKeys("CBE",Keys.TAB);
		//Clear and Enter the Destination city and do Tab
		WebElement dst = driver.findElementById("txtStationTo");
		dst.clear();
		dst.sendKeys("NDLS",Keys.TAB);
		//Find all the train names
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]")));
		List<WebElement> list = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
		ArrayList<String> arrayList = new ArrayList<String>();
		for (WebElement webElement : list) {
			arrayList.add(webElement.getText());
		}
		//Get the size of it
		System.out.println("Size of the ArrayList is "+ arrayList.size());
		//Print the sorted Train names
		System.out.println("Sorted Train names are ....");
		Collections.sort(arrayList);
		for (String string : arrayList) {
			System.out.println("\t"+string);
		}
		//Add the list into a new Set
		HashSet<String> set = new HashSet<String>();
		set.addAll(arrayList);
		//And print the size of it
		System.out.println("Size of set is "+set.size());
		for (Object object : set) {
			System.out.println("\t"+object);
		}
	}
}
