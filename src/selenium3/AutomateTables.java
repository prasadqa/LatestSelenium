package selenium3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateTables {

	public static WebDriver driver;
	public static final String url = "https://www.techlistic.com/p/demo-selenium-practice.html";
	public static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		List<WebElement> tableRows,tableCols; 
				
		tableRows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		for (int i=0;i<=tableRows.size();i++) {
			tableCols = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//td"));
			for(int j=0;j<=tableCols.size();j++) {
				String data = tableCols.get(j).getText();
				System.out.print(data+"    ");
			}
			
		}
		driver.quit();
		

	}

}
