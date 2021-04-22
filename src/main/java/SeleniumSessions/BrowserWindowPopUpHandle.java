package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUpHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent Window Id is : " + parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child Window Id is : " + childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window URL : " + driver.getCurrentUrl());
		System.out.println("Child Window Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window URL : " + driver.getCurrentUrl());
		System.out.println("Parent Window Title : " + driver.getTitle());
		driver.quit();

	}

}
