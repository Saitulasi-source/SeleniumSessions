package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopUpWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt = 'LinkedIn OrangeHRM group']")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent Window Id : " + parentWindowId);
		String childWindowId = it.next();
		System.out.println("Child Window Id : " + childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window URL : " + driver.getCurrentUrl());
		System.out.println("Child Window Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		Set<String> facebookWindowHandle = driver.getWindowHandles();
		Iterator<String> it1 = facebookWindowHandle.iterator();
		it1.next();
		String facebookWindowId = it1.next();
		System.out.println("Facebook Window Id : " + facebookWindowId);
		driver.switchTo().window(facebookWindowId);
		System.out.println("Facebook Window URL : " + driver.getCurrentUrl());
		System.out.println("Facebook Window Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		Set<String> twitterWindowHandle = driver.getWindowHandles();
		Iterator<String> it2 = twitterWindowHandle.iterator();
		it2.next();
		String twitterWindowId = it2.next();
		System.out.println("Twitter Window Id : " + twitterWindowId);
		driver.switchTo().window(twitterWindowId);
		System.out.println("Twitter Window URL : " + driver.getCurrentUrl());
		System.out.println("Twitter Window Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on youtube']")).click();
		Set<String> youtubeWindowHandle = driver.getWindowHandles();
		Iterator<String> it3 = youtubeWindowHandle.iterator();
		it3.next();
		String youtubeWindowId = it3.next();
		System.out.println("Youtube Window Id : " + youtubeWindowId);
		driver.switchTo().window(youtubeWindowId);
		System.out.println("Youtube Window URL : " + driver.getCurrentUrl());
		System.out.println("Youtube Window Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window URL : " + driver.getCurrentUrl());
		System.out.println("Parent Window Title : " + driver.getTitle());
		driver.quit();
	}

}
