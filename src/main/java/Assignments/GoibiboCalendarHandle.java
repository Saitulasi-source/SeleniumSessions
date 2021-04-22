package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboCalendarHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!ETA!108599293!6504095653!491619965162!e!goibibo!c!&ef_id=EAIaIQobChMItu6Yl_3e7wIVhcDACh0UpwaMEAAYASAAEgLplvD_BwE:G:s&gclid=EAIaIQobChMItu6Yl_3e7wIVhcDACh0UpwaMEAAYASAAEgLplvD_BwE");
		driver.findElement(By.id("departureCalendar")).click();
		By calendar = By.cssSelector("div.DayPicker.DayPicker--en div.calDate");
		// selectDate("div", "6");
		// selectDate(calendar, "11");
		 selectFutureDate("1", "January", "2022");

	}

	public static void selectDate(String htmlTag, String day) {
		driver.findElement(By.xpath("//" + htmlTag + "[text()='" + day + "']")).click();
	}

	public static void selectDate(By locator, String day) {

		List<WebElement> daysList = driver.findElements(locator);
		System.out.println(daysList.size());
		for (WebElement e : daysList) {
			String text = e.getText();
			if (text.equals(day)) {
				e.click();
				break;
			}

		}
	}

	public static String[] getMonthYear(String monthYear) {
		return monthYear.split(" ");
	}

	public static void selectFutureDate(String exday, String exmonth, String exyear) {

		if (exmonth.equals("February") && Integer.parseInt(exday) > 29) {
			System.out.println("Wrong date : " + exmonth + " : " + exday);
			return;
		}
		String monthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption")).getText();
		while (!(getMonthYear(monthYear)[0].equals(exmonth) && getMonthYear(monthYear)[1].equals(exyear))) {
			System.out.println(monthYear);
			driver.findElement(By.xpath("//span[contains(@class,'DayPicker-NavButton--next')]")).click();
			monthYear = driver.findElement(By.cssSelector("div.DayPicker-Caption")).getText();
		}
		selectDate("div", exday);
	}

}
