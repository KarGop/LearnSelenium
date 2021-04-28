package week3.day2;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://www.leafground.com/pages/TextChange.html");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click ME!']"))).click();
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    // To capture the alert message
    System.out.println("Aler Message is '"+alert.getText()+"'");
    // Capture the whole screen
    //Robot robot = new Robot();
    //Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    // image = robot.createScreenCapture(area);
    //BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    //ImageIO.write(image, "png", new File("./snap/alert.png"));
    // To click on the 'OK' button of the alert
    alert.accept();
	}
}