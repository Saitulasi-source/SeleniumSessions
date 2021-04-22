package Assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCRMProXpath {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		driver.findElement(By.linkText("2")).click();

		// //a[text() = 'Sai
		// Tulasi']/parent::td/preceding-sibling::td/input[@type='checkbox']

		// a[text() = 'Sai Tulasi']/parent::td/following-sibling::td/a

		// a[text() = 'Sai Tulasi']/parent::td/following-sibling::td/span

		// (//a[text() = 'Sai Tulasi']/parent::td/following-sibling::td/span)[2]

		// (//a[text() = 'Sai Tulasi']/parent::td/following-sibling::td/a)[2]

		selectContact("Sai Tulasi");
		String companyName = getCompanyName("Sai Tulasi");
		System.out.println(companyName);
		String phoneNumber = getPhoneNumber("Sai Tulasi");
		System.out.println(phoneNumber);
		String mobileNumber = getMobileNumber("Sai Tulasi");
		System.out.println(mobileNumber);
		String emailID = getEmailId("Sai Tulasi");
		System.out.println(emailID);
		List<String> contactInfoList = getContactInfo("Sai Tulasi");
		System.out.println(contactInfoList);
	}

	public static void selectContact(String name) {
		String xpath = "//a[text() = '" + name + "']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(xpath)).click();
	}

	public static String getCompanyName(String name) {
		String xpath = "//a[text() = '" + name + "']/parent::td/following-sibling::td/a";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static String getPhoneNumber(String name) {
		String xpath = "//a[text() = '" + name + "']/parent::td/following-sibling::td/span";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static String getMobileNumber(String name) {
		String xpath = "(//a[text() = '" + name + "']/parent::td/following-sibling::td/span)[2]";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static String getEmailId(String name) {
		String xpath = "(//a[text() = '" + name + "']/parent::td/following-sibling::td/a)[2]";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static List<String> getContactInfo(String name) {
		List<String> contactInfoList = new ArrayList<String>();
		String companyName = getCompanyName("Sai Tulasi");
		String phoneNumber = getPhoneNumber("Sai Tulasi");
		String mobileNumber = getMobileNumber("Sai Tulasi");
		String emailID = getEmailId("Sai Tulasi");
		contactInfoList.add(companyName);
		contactInfoList.add(phoneNumber);
		contactInfoList.add(mobileNumber);
		contactInfoList.add(emailID);
		return contactInfoList;

	}
}
