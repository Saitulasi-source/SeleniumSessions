package Assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketInfoScoreXpath {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/south-africa-women-tour-of-india-2020-21-1253264/india-women-vs-south-africa-women-2nd-t20i-1253273/full-scorecard");

		// a[contains(text(),'Shafali Verma')]/parent::td/following-sibling::td
		// a[contains(text(),'Nadine de Klerk')]/parent::td[@class =
		// 'text-nowrap']/following-sibling::td 
		// a[contains(text(),'Nonkululeko Mlaba')]/parent::td/following-sibling::td

		String wicketTakerName = getWicketTakerName("Shafali Verma");
		System.out.println(wicketTakerName);
		List<String> scoreList = getBatsmenScoreCard("Shafali Verma");
		System.out.println(scoreList);
		List<String> bowlingScoreList = getBowlingScoreCard("Nadine de Klerk");
		System.out.println(bowlingScoreList);
	}

	public static String getWicketTakerName(String batsmenName) {

		String xpath = "//a[contains(text(),'" + batsmenName + "')]/parent::td/following-sibling::td";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static List<String> getBatsmenScoreCard(String batsmenName) {
		List<String> scoreCardList = new ArrayList<String>();
		String xpath = "//a[contains(text(),'" + batsmenName + "')]/parent::td/following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(xpath));
		for (int i = 1; i < scoreList.size(); i++) {
			String score = scoreList.get(i).getText();
			if (!score.isEmpty()) {
				scoreCardList.add(score);
			}
		}
		return scoreCardList;
	}

	public static List<String> getBowlingScoreCard(String playerName) {
		List<String> scoreCardList = new ArrayList<String>();
		String xpath = "//a[contains(text(),'" + playerName
				+ "')]/parent::td[@class = 'text-nowrap']/following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(xpath));
		for (int j = 0; j < scoreList.size(); j++) {
			String score = scoreList.get(j).getText();
			if (!score.isEmpty()) {
				scoreCardList.add(score);
			}
		}
		return scoreCardList;
	}
}
