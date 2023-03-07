package selenium3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles {
	
	public static WebDriver driver;
	public static final String url ="https://www.hyrtutorials.com/p/window-handles-practice.html";
	
	
	
	 
	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	Thread.sleep(3000);
	String parentWindow =  driver.getWindowHandle();
	
	driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
	driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();
	
	Set<String> handles = driver.getWindowHandles();
	for (String string : handles) {
		
		String windowtitles = driver.switchTo().window(string).getTitle();
		if(windowtitles.contains("Basic Controls")) {
			System.out.println("focus on target window");
			break;
		}
	}
	driver.findElement(By.id("firstName")).clear();
	driver.findElement(By.id("firstName")).sendKeys("success");
	driver.close();
	for (String string : handles) {
		
		String windowtitles = driver.switchTo().window(string).getTitle();
		if(windowtitles.contains("AlertsDemo")) {
			System.out.println("focus on target window");
			break;
		}
	}
	driver.findElement(By.id("promptBox")).click();
	Alert alt = driver.switchTo().alert();
	alt.sendKeys("success");
	alt.accept();
	Thread.sleep(3000);
	String txt = driver.findElement(By.xpath("//div[@id='output']")).getText();
	System.out.println(txt);
	driver.close();
	Thread.sleep(3000);
	driver.switchTo().window(parentWindow);
	System.out.println(driver.getTitle());
	driver.quit();
	
	
	
	
	
	
	

}
}