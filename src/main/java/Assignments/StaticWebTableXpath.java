package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableXpath {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]

		int rowCount = driver.findElements(By.xpath("//table[@id = 'customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id = 'customers']//th")).size();
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[";

		for (int i = 2; i <= rowCount; i++) {
			for (int j = 1; j <= colCount; j++) {
				String xpath = beforeXpath + i + afterXpath + j + "]";
				// System.out.println(xpath);
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + " ");
			}

			System.out.print("\n");
		}

	}

}
