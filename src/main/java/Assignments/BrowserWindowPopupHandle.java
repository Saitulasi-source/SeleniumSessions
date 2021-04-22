package Assignments;

import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowPopupHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt = 'LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt = 'OrangeHRM on youtube']")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("Parent Window Id : " + parentWindowId);
		String childWindowId1 = it.next();
		System.out.println("Child Window Id1 : " + childWindowId1);
		String childWindowId2 = it.next();
		System.out.println("Child Window Id2 : " + childWindowId2);
		String childWindowId3 = it.next();
		System.out.println("Child Window Id3 : " + childWindowId3);
		String childWindowId4 = it.next();
		System.out.println("Child Window Id4 : " + childWindowId4);
		driver.switchTo().window(childWindowId1);
		System.out.println("Child Window1 URL : " + driver.getCurrentUrl());
		System.out.println("Child Window1 Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(childWindowId2);
		System.out.println("Child Window2 URL : " + driver.getCurrentUrl());
		System.out.println("Child Window2 Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(childWindowId3);
		System.out.println("Child Window3 URL : " + driver.getCurrentUrl());
		System.out.println("Child Window3 Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(childWindowId4);
		System.out.println("Child Window4 URL : " + driver.getCurrentUrl());
		System.out.println("Child Window4 Title : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window URL : " + driver.getCurrentUrl());
		System.out.println("Parent Window Title : " + driver.getTitle());
		driver.quit();

	}

}