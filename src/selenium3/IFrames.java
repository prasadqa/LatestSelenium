package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {
	
	public static WebDriver driver;
	public static final String url ="https://www.hyrtutorials.com/p/frames-practice.html";
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='course']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Java");
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[@class='basicControls']//div//ol//li[1]")).getText();
		System.out.println("frame 1 Text:  "+ text );
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm3']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm2']")));
		String frame3Text = driver.findElement(By.xpath("//div[@class='basicControls']//h1")).getText();
		System.out.println("frame 3 in frame 2 Text:  "+ frame3Text );
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		////select[@id='selectnav2']
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='selectnav2']"));
		Select select2 = new Select(dropdown2);
		select2.selectByVisibleText("Contact");
	
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("frames over");
		
		
		
	}

}
