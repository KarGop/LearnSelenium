package week2.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.text.NumberFormat;
import java.text.ParseException;

public class WebTable {
	public static void main(String[] args) throws IOException {	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		//Get the number of rows
		List<WebElement> table1 = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println("Number of rows in the table : "+ table1.size());
		//Get the number of columns
		List<WebElement> column = driver.findElements(By.xpath("//table[@id='table_id']//tr[1]/th"));
		System.out.println("Number of columns in the table : "+column.size());
		//Get the list of mentors
		List<WebElement> mentorlist = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[5]"));
		System.out.println("Mentor names are : ");
	    for (WebElement eachMentor : mentorlist) {
			System.out.println(eachMentor.getText());
		}
	    // Get the progress value of 'Learn to interact with Elements' 
		 System.out.println("progress value of 'Learn to interact with Elements' : "+driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[3]/td[2]")).getText());
		// Find the vital task for the least completed progress and check the box
		 List<WebElement> progress =  driver.findElementsByXPath("//table[@id='table_id']//tr/td[2]");
		 List<Integer> intList=new ArrayList<Integer>();
		 for (WebElement eachprogress : progress) {
			String text =eachprogress.getText();
			//System.out.println(text);
			String textNums=text.replaceAll("[^0-9]","");
			int numAlone =Integer.parseInt(textNums);
			intList.add(numAlone);
			//System.out.println(numAlone);
		}
		 int minProgress = Collections.min(intList);
		 System.out.println("Least progress % is "+minProgress );
		 driver.findElementByXPath("//td[contains(text(),'"+minProgress+"%')]/following-sibling::td/input").click();
	
		 //Take screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snap/webtable.png"));
	}
}