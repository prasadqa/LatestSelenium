package selenium3;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dates {
	
	public static WebDriver driver;
	public static final String url = "https://www.redbus.in/";

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		String givenDate = "6-Apr-2023";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
//		driver.findElement(By.xpath("//input[@id='onward_cal']")).sendKeys(givenDate);
		Thread.sleep(3000);
		String[] temp = givenDate.split("-");
		String date = temp[0];
		String month = temp[1];
		String year = temp[2];
		System.out.println("date: "+date+"  "+month+"  "+year);
		
		WebElement monthYear =  driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr[1]//td[2]"));
		String str = monthYear.getText();
		String[] sliptStr = str.split(" ");
		System.out.println(sliptStr[0]+"  "+sliptStr[1]);
		while (!year.equalsIgnoreCase(sliptStr[1].trim())) {
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr[1]//td[3]")).click();
			Thread.sleep(1000);
			str = monthYear.getText();
			sliptStr = str.split(" ");
			System.out.println("first year loop"+sliptStr[0]+"  "+sliptStr[1]);
			
		}
		while (!month.equalsIgnoreCase(sliptStr[0].trim())) {
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr[1]//td[3]")).click();
			Thread.sleep(5000);
			str = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr[1]//td[2]")).getText();
			sliptStr = str.split(" ");
			System.out.println("second month loop"+sliptStr[0]+"  "+sliptStr[1]);
		}
		List<WebElement> rows,cols;
		
		rows = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr"));
		System.out.println("row size: "+rows.size());
		for(int i =2;i<rows.size();i++){
			cols = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody//tr["+i+"]//td"));
			System.out.println("cols size: "+cols.size());
			for(int j=0;j<cols.size();j++) {
				String calDate = cols.get(j).getText();
				System.out.println("dates "+calDate);
			
				if(date.trim().equalsIgnoreCase(calDate.trim())) {
					Thread.sleep(3000);
					cols.get(j).click();
					break;
				}
			}
			
		}
		Thread.sleep(30000);
		
		
		driver.quit();
		
		
		
		
		
		

	}

}
