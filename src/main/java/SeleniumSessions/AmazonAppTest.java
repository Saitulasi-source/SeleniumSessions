package SeleniumSessions;

public class AmazonAppTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.init_driver("chrome");
		br.launchUrl("https://www.amazon.com");
		String title = br.getPageTitle();
		System.out.println(title);
		if (title.contains("Online Shopping")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		String url = br.getPageUrl();
		System.out.println(url);
		br.quitBrowser();
	}

}
