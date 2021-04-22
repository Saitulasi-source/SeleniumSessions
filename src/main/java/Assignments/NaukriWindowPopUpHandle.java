package Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriWindowPopUpHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com");
		Set<String> handles = driver.getWindowHandles();
		List<String> handleslist = new ArrayList<String>(handles);
		String parentWindowId = handleslist.get(0);
		String child1WindowId = handleslist.get(1);
		String child2WindowId = handleslist.get(2);
		driver.switchTo().window(child1WindowId);
		driver.close();
		driver.switchTo().window(child2WindowId);
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window Id URL : " + driver.getCurrentUrl());
		System.out.println("Parent Window Id Title : " + driver.getTitle());
		driver.quit();

	}

}
