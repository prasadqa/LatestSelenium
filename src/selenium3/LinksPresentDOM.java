package selenium3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksPresentDOM {

	public static WebDriver driver;
	public static int respoceCode;
	public static int nullurls = 0;
	public static int homeurls = 0;
	public static int verifiedurls = 0;
	public static HttpURLConnection http;
	public static final String url = "https://www.naukri.com/";
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links "+links.size());
		
		for (WebElement webElement : links) {
			String urls = webElement.getAttribute("href");
//			System.out.println("available links : "+urls);
			if(urls==null||urls.isEmpty()) {
				System.out.println(urls +"url is not there ");
				nullurls++;
				continue;
			}
			if(urls.contains("homepage")) {
				System.out.println(urls +"URL belongs to another domain, skipping it.");
				homeurls++;
				continue;
			}
			try {
				verifiedurls++;
				http = (HttpURLConnection) (new URL(urls).openConnection());
				http.setRequestMethod("HEAD");
				http.connect();
				respoceCode = http.getResponseCode();
				if(respoceCode>=400) {
					System.out.println( urls + "link is broken");
				}else {
					System.out.println( urls + "link is valid");
				}
				
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("null urls "+nullurls);
		System.out.println("homepage urls "+homeurls);
		System.out.println("varified urls "+ verifiedurls);
		System.out.println("total urls :"+nullurls+homeurls+verifiedurls);
		driver.quit();
		

	}

}
