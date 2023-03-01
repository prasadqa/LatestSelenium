package selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class navigationsMethods {
	
	public static WebDriver driver; 
	public static final String url ="https://www.facebook.com/";

	public static void main(String[] args) {
		 System.setProperty("webdriver.gecko.driver", "/Users/challaprasad/Documents/AutomationSoftwares/geckodriver");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get(url);
		 String title = driver.getTitle();
		 System.out.println("Website Name: "+title);
		 driver.close();		 

	}

}
