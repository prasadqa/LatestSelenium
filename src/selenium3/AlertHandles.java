package selenium3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandles {

	public static WebDriver driver;
	public static final String url = "https://nxtgenaiacademy.com/alertandpopup/";
	public static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='alertbox']")).click();
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
		alrt.dismiss();
		String str = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("canceled :"+str);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		Thread.sleep(3000);
		alrt = driver.switchTo().alert();
		Thread.sleep(3000);
		alrt.sendKeys("Yes");
		alrt.accept();
		Thread.sleep(3000);
		str = driver.findElement(By.xpath("//p[@id='demoone']")).getText();
		System.out.println("For Yes :"+str);
		driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
		Thread.sleep(3000);
		alrt = driver.switchTo().alert();
		alrt.sendKeys("No");
		Thread.sleep(3000);
		alrt.accept();
		Thread.sleep(3000);
		str = driver.findElement(By.xpath("//p[@id='demoone']")).getText();
		System.out.println("For No :"+str);
		driver.quit();
	
		
	}

}
