package week4.day2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class Ajio {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//Launch the URL 
		driver.get("https://www.ajio.com/shop/sale");
		//Maximize browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String mainWindow = driver.getWindowHandle();
		//Enter Bags in the Search field 
		driver.findElementByXPath("//input[@placeholder='Search AJIO']").sendKeys("Bags",Keys.ENTER);
		//Select Women Handbags
		driver.findElementByXPath("//label[@for='Women']").click();
		//Click on five grid
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("five-grid")));
		driver.findElementByClassName("five-grid").click();
		//Select SORT BY as "What's New"
		WebElement element = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select dd1 = new Select(element);
		dd1.selectByVisibleText("What's New");
		//Select price and Enter min and max values
		WebElement price = driver.findElementByXPath("//span[text()='price']");
		price.click();
		//This will scroll the page till the element is found
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");//To scroll down the web page by pixel
        //js.executeScript("arguments[0].scrollIntoView();", price);//To scroll down the web page by the visibility of the element
		driver.findElementById("minPrice").sendKeys("2000");
		driver.findElementById("maxPrice").sendKeys("5000",Keys.ENTER);
		//driver.findElementByClassName("rilrtl-button ic-toparw").click();
		System.out.println("Parent Title : "+driver.getTitle());
		//Click on the first product
		driver.findElementByXPath("(//div[@class=\"name\"])[1]").click();
		//get WindowsHandles
		System.out.println("Get WindowsHandles : ");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		for (String string : list) {
			System.out.println("\t"+string);
		}
		//switch to new windows (tab)
		driver.switchTo().window(list.get(1));
		// Get the current page title
		System.out.println("Current page Title : "+driver.getTitle());
		//Get the actual price
		String actualPrice_str = driver.findElementByXPath("//div[@class='prod-sp']").getText();
		System.out.println("Actual price of Bag: "+actualPrice_str);
		// Get the code for applying discount
		String couponCode = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String[] split = couponCode.split("\\r?\\n");//split by newline (\n)
		System.out.println("Coupon code for applying Discount is '"+ split[1]+"'");
		//String[] split2 = couponCode.split(" ");
		//for (String string : split2) {
			//System.out.println(string);
		//}
		//Get Discount price
		String discountPriceStr = driver.findElementByXPath("//div[@class='promo-discounted-price']/span").getText();
		String dPNumAlone = discountPriceStr.replaceAll("\\D", "");
		int discountPrice = Integer.parseInt(dPNumAlone);
		System.out.println("Discount Price of the Bag is Rs."+discountPrice);
		//Check the availability of the product for pincode 560043
		driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
		driver.findElementByName("pincode").sendKeys("560043");
		driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
		//print the expected delivery date if it is available
		System.out.println("Expected Deleivery for pincode 560043 "+driver.findElementByClassName("edd-message-success-details-highlighted").getText());
		// Click on Other Informations under Product Details
		driver.findElementByClassName("other-info-toggle").click();
		System.out.println("Customer Care Address:\n\t "+driver.findElementByXPath("//div[text()='Customer Care Address']/following::div[@class=\"title\"][1]").getText());
		//Click on ADD TO BAG by actions 
		WebElement addToBag = driver.findElementByXPath("//*[text()='ADD TO BAG']");
		Actions actions = new Actions(driver);
		actions.moveToElement(addToBag).click().perform();
		// click Proceed to bag
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='PROCEED TO BAG']")).click();
		//Check the Order Total before apply coupon
		Thread.sleep(2000);
		System.out.println("Order Total before applying coupon is "+driver.findElementByXPath("//span[@class='price-value bold-font']").getText());
		// enter the coupon code
		driver.findElementById("couponCodeInput").sendKeys(split[1]);
		// click apply
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		//Validate discount price
		try {
			boolean voucherInvalid = driver.findElement(By.className("voucher-error error-message info")).isDisplayed();
			if (voucherInvalid) {
					System.out.println("voucher is invalid!!");
					System.out.println(driver.findElement(By.className("voucher-error error-message info")).getText());
				} 
			}
		catch(Exception e){
			System.out.println("There is no Error message for coupon!");
		}
		finally {
			System.out.println(driver.findElementByClassName("applied-voucher-message").getText());
			//Get Order Total 
			String text = driver.findElement(By.xpath("//span[@class='price-value bold-font']")).getText();
			String[] strings = text.split(" ");
			//for (int i = 0; i < strings.length; i++) {
				//System.out.println(strings[i]);
			//}
			String OrderTotalNumAlone = strings[1].replaceAll(",", "");
			//Convert string into Float
			float f=Float.parseFloat(OrderTotalNumAlone);
			//Roundoff float and convert into int
			int OrderTotal = (int)(Math.round(f));
			System.out.println("Order Total after applying coupon is Rs."+ OrderTotal);
			if(discountPrice == OrderTotal) {
				System.out.println("Verification Pass:)");
			}else {
				System.out.println("Verification Failed:(");
		}}
		// Click on Delete
		driver.findElementByClassName("delete-btn").click();
		//Delete from Bag
		//driver.findElementByClassName("delete-btn").click();
		driver.findElement(By.xpath("//div[text()='MOVE TO CLOSET']/following-sibling::div")).click();
		System.out.println("\nItem deleted.....");
		driver.close();
		// At the end, come back to the main window
		driver.switchTo().window(mainWindow);
		driver.close();
	}
}