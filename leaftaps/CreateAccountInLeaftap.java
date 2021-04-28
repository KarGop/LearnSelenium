package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountInLeaftap {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Account").click();
		driver.findElementById("accountName").sendKeys("Learner_testt");
		driver.findElement(By.id("groupNameLocal")).sendKeys("Karthi");
		driver.findElementByName("parentPartyId").sendKeys("democlass1");
		driver.findElementById("officeSiteName").sendKeys("www.xyz.com");
		driver.findElementById("annualRevenue").sendKeys("1000000");
		WebElement industry = driver.findElementByName("industryEnumId");
		Select dd1 = new Select(industry);
		dd1.selectByVisibleText("Computer Software");
		WebElement ownership = driver.findElementByName("ownershipEnumId");
		Select dd2 = new Select(ownership);
		dd2.selectByValue("OWN_PUBLIC_CORP");
		driver.findElementById("sicCode").sendKeys("9876543210");
		WebElement source = driver.findElementById("dataSourceId");
		Select dd3=new Select(source);
		dd3.selectByIndex(8);
		WebElement initialTeam = driver.findElementById("initialTeamPartyId");
		Select dd4=new Select(initialTeam);
		dd4.selectByValue("DemoSalesTeam1");
		driver.findElementByName("description").sendKeys("testtttt");
		driver.findElementByName("importantNote").sendKeys("IMPORTANT !!!!");
		WebElement currency = driver.findElementById("currencyUomId");
		Select dd5=new Select(currency);
		dd5.selectByValue("EUR");
		driver.findElementById("numberEmployees").sendKeys("1000");
		driver.findElementById("tickerSymbol").sendKeys("MSFT");
		WebElement campaign = driver.findElementById("marketingCampaignId");
		Select dd6=new Select(campaign);
		dd6.selectByValue("CATRQ_ROADNTRACK");
		//Contact_info
driver.findElementById("primaryPhoneCountryCode").sendKeys("+91");
driver.findElementById("primaryPhoneAreaCode").sendKeys("11");
driver.findElementById("primaryPhoneExtension").sendKeys("abc");
driver.findElementById("primaryEmail").sendKeys("testleaf_learner@gmail.com");
driver.findElementById("primaryPhoneNumber").sendKeys("1234569870");
driver.findElementById("primaryPhoneAskForName").sendKeys("helpdesk");
driver.findElementById("primaryWebUrl").sendKeys("www.testleaf.com");
//Address
driver.findElementById("generalToName").sendKeys("XXXX");
driver.findElementById("generalAttnName").sendKeys("YYYY");
driver.findElementById("generalAddress1").sendKeys("1/123");
driver.findElementById("generalAddress2").sendKeys("qwerty_street");
driver.findElementById("generalCity").sendKeys("Berlin");
WebElement country = driver.findElementById("generalCountryGeoId");
Select dd7=new Select(country);
dd7.selectByVisibleText("United States");
driver.findElementById("generalPostalCode").sendKeys("901246");
WebElement state = driver.findElementById("generalStateProvinceGeoId");
Select dd8=new Select(state);
dd8.selectByValue("TX");
driver.findElementByName("generalPostalCodeExt").sendKeys("925");
driver.findElementByClassName("smallSubmit").click();
System.out.println(driver.getTitle());	
//driver.quit();
	}
}
