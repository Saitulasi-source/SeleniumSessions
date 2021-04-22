package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopUpHandleWithList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> handleslist = new ArrayList<String>(handles);
		String parentWindowId = handleslist.get(0);
		String childWindowId = handleslist.get(1);
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
