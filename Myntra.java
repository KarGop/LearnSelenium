package week3.day2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);
		//Launch the URL 
		driver.get("https://www.myntra.com/");
		//Maximize browser window
		driver.manage().window().maximize();
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Women' to perform mouse hover 
     WebElement menuOption = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
     //Mouse hover menuOption 'Women'
     actions.moveToElement(menuOption).build().perform();
     Thread.sleep(1000);
     //Now Select 'Jackets & Coats' from sub menu which has got displayed on mouse hover of 'Women'
     WebElement subMenuOption = driver.findElement(By.xpath("//a[contains(text(),'Jackets & Coats')]")); 
     //Click 'Jackets & Coats'
     actions.moveToElement(subMenuOption).click().perform();
     System.out.println("Jackets and Coats selected");
     //Find the total count of item
     Thread.sleep(3000);
     String items = driver.findElement(By.xpath("//h1[text()='Coats & Jackets For Women']/following-sibling::span")).getText();
     String TextItems=items.replaceAll("[^0-9]","");
     int total=Integer.parseInt(TextItems);
     System.out.println("Total items "+total);
     //Validate the sum of categories count matches
     List<WebElement> list = driver.findElementsByXPath("//*[@class='categories-list']/li");
     int sum=0;
     for (int i = 0; i < list.size(); i++) {
    	 String text=list.get(i).getText();
 		 System.out.println(text);
 		 String textNums=text.replaceAll("[^0-9]","");
		 int numAlone =Integer.parseInt(textNums);
 		 sum+=numAlone;
	 }
     System.out.println("Sum of Jackets and Coats : "+sum);
     if(total==sum) {
    	 System.out.println("sum of categories count matches with Total count!!!");
     }else {
    	 System.out.println("sum of categories count not matches with Total count :(");
     }
     //Check Coats
     driver.findElementByXPath("(//label[@class=\"common-customCheckbox vertical-filters-label\"])[2]").click();
     System.out.println("Coats checkbox is selected ");
     //Click + More option under BRAND
     driver.findElementByClassName("brand-more").click();
     //Type MANGO and click check box
     driver.findElementByXPath("//input[@placeholder=\"Search brand\"]").sendKeys("MANGO");
     driver.findElementByXPath("//label[@class=\" common-customCheckbox\"]").click();
     //Close the pop-up x
     driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
     //Get no of Mango Coats
     Thread.sleep(2000);
     String  totalMangoCoats = driver.findElement(By.xpath("//input[@value='MANGO']/following-sibling::span")).getText();
     String numAlone = totalMangoCoats.replaceAll("[^0-9]", "");
     int totalMCoats = Integer.parseInt(numAlone);
     System.out.println("No of Mango coats :"+ totalMCoats);
    //Confirm all the Coats are of brand MANGO
     List<WebElement> name = driver.findElementsByXPath("//h3[@class = 'product-brand']");
     int count=0;
     for (int i = 0; i < name.size(); i++) {
    	String a = name.get(i).getText();
		if (a.equals("MANGO")) {
			count++;
		}
	}
     if (count==totalMCoats) {
		System.out.println("All "+count +" coats are of brand Mango!");
	}
     //Sort by Better Discount
     WebElement sortBy = driver.findElementByXPath("//div[@class=\"sort-sortBy\"]");
     actions.moveToElement(sortBy).perform();
     driver.findElementByXPath("//label[text()='Better Discount']").click();
     //Find the price of first displayed item
     System.out.println("Item1 ........");
     System.out.println("\tActual Price "+driver.findElementByXPath("(//span[@class='product-strike'])[1]").getText());
     System.out.println("\tAvailable Discount "+driver.findElementByXPath("(//span[@class='product-discountPercentage'])[1]").getText());
     String text = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
     System.out.println("\tDiscounted price of the first coat is "+text);
     //Mouse over on size of the first item
     System.out.println("Available sizes are ..");
     WebElement item1 = driver.findElementByXPath("(//h3[@class = 'product-brand'])[1]");
     actions.moveToElement(item1).perform();
     //Get available sizes for first coat
     List<WebElement> sizeList = driver.findElementsByXPath("(//div[@class='product-productMetaInfo'])[1]/h4[2]/span");
     for (int i = 0; i < sizeList.size(); i++) {
		System.out.println("\t"+sizeList.get(i).getText().replaceAll(",", ""));
	}
     //Click on WishList
     driver.findElementByXPath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']").click();
     System.out.println("Item added into WishList!!!");
     driver.close();
     }}
