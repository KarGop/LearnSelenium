package test;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class salesDemo {
		
	public static void main(String[] args) throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);		
		driver.get("https://salesdemo.habiletechnologies.com");
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		WebElement id = driver.findElementById("uid");
		wait.until(ExpectedConditions.visibilityOf(id));
		id.sendKeys("qatest@habile.in");
		driver.findElementById("pwd").sendKeys("Qatest123$");
		driver.findElementById("login-button").click();
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		WebElement Clients = driver.findElement(By.id("client-dropdown"));
		//WebElement Clients = driver.findElement(By.xpath("//a[@class='ng-binding dropdown-toggle']"));
		wait.until(ExpectedConditions.visibilityOf(Clients));
		actions.moveToElement(Clients).build().perform();
		driver.findElement(By.xpath("//a[@has-permission='READ_CLIENT']")).click();
		Thread.sleep(2000);
		driver.findElementById("client_createbutton").click();
		Thread.sleep(2000);
		driver.findElementById("genderId_chosen").click();
		driver.findElement(By.xpath("(//li[@class='active-result'])[2]")).click();
		System.out.println(driver.getTitle());
		//driver.findElement(By.xpath("(//ul[@class='chosen-results']//li)[3]")).click();
		
	}

}
