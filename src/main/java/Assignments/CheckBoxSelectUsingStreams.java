package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxSelectUsingStreams {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		driver.findElement(By.linkText("CONTACTS")).click();
		List<WebElement> namesList = driver.findElements(By.xpath("//a[text()='Chandru Selvam']/parent::td/preceding-sibling::td/input[@type='checkbox']"));
		System.out.println(namesList.size());
		namesList.stream().forEach(ele->ele.click());
}

}
