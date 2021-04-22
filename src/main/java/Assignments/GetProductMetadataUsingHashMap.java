package Assignments;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetProductMetadataUsingHashMap {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("saitulasi@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//input[@name = 'search']")).sendKeys("macbook");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		driver.findElement(By.linkText("MacBook Pro")).click();
		String title = driver.findElement(By.xpath("//h1[contains(text(),'MacBook Pro')]")).getText();

		String brand[] = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[28]")).getText().split(":");
		System.out.println(brand[0] + " " + brand[1]);

		String product[] = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[29]")).getText().split(":");
		System.out.println(product[0] + " " + product[1]);

		String reward[] = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[30]")).getText().split(":");
		System.out.println(reward[0] + " " + reward[1]);

		String availability[] = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[31]")).getText()
				.split(":");
		System.out.println(availability[0] + " " + availability[1]);

		String price = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[32]")).getText();

		String exTax[] = driver.findElement(By.xpath("(//ul[@class= 'list-unstyled']/li)[33]")).getText().split(":");
		System.out.println(exTax[0] + " " + exTax[1]);

		Map<String, String> prodMap = new HashMap<String, String>();
		prodMap.put("Name", title);
		prodMap.put(brand[0], brand[1].trim());
		prodMap.put(product[0], product[1].trim());
		prodMap.put(reward[0], reward[1].trim());
		prodMap.put(availability[0], availability[1].trim());
		prodMap.put("Price", price);
		prodMap.put(exTax[0], exTax[1].trim());

		for (Map.Entry<String, String> entry : prodMap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + " value = " + entry.getValue());
		}

	}

}
