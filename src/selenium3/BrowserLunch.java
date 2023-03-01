package selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLunch {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/challaprasad/Documents/AutomationSoftwares/chromedriver_mac64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println("website name"+title);
		driver.close();
		
	}

}
