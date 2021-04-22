package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopUpWindowHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent Window Id is : " + parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child Window Id is : " + childWindowId);
		String title = switchToWindowAndGetTitle(childWindowId);
		System.out.println("Child Window Title : " + title);
		driver.close();
		String url = switchToWindowAndGetURL(parentWindowId);
		System.out.println("Parent Window URL : " + url);
		driver.quit();

	}

	public static String switchToWindowAndGetTitle(String windowId) {
		driver.switchTo().window(windowId);
		String title = driver.getTitle();
		return title;
	}

	public static String switchToWindowAndGetURL(String windowId) {
		driver.switchTo().window(windowId);
		String url = driver.getCurrentUrl();
		return url;
	}

}
