package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBWebDriver {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/saipraveen/downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		String title = driver.getTitle();
		System.out.println("Page Title is : " + title);
		if (title.equals("Facebook")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		driver.quit();

	}

}
