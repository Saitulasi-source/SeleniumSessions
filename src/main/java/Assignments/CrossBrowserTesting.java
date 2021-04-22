package Assignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		String browser = "Chrome";
		
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/Users/saipraveen/downloads/chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/Users/saipraveen/downloads/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "/Users/saipraveen/downloads/edgedriver");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please pass the correct browser name...");
			break;
		}
		
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		if (title.equals("Google")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		driver.quit();
		

	}

}
