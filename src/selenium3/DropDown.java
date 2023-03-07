package selenium3;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	public static WebDriver driver;
	public static final String url="https://www.redbus.in/online-booking/apsrtc";
	
	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		WebElement dropDown = driver.findElement(By.xpath("//input[@id='txtSource']"));
		if(dropDown.isDisplayed()) {
			dropDown.clear();
			dropDown.sendKeys("hyd");
		}else {
			System.out.println("element is not displayed");
		}
		Thread.sleep(3000);
		List<WebElement> suggetionList = driver.findElements(By.xpath("//div[@class='C120_suggestions_list_area']//div[@data-cc='IND']"));
		
		System.out.println("number of suggetion :"+suggetionList.size());
		
		for (WebElement webElement : suggetionList) {
			
			String cities = webElement.getText();
			System.out.println("suggetion list : "+ cities);
		}
		
		suggetionList.get(3).click();
		Thread.sleep(3000);
		WebElement selectedEle = driver.findElement(By.xpath("//input[@id='txtSource']"));
		String selectedCity = selectedEle.getAttribute("value");
		System.out.println("souce city : "+selectedCity);
		Thread.sleep(3000);
		// with select class most of the times it works for select tagname 
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='course']")));
		select.selectByIndex(2);
		Thread.sleep(10000);
		select.selectByVisibleText("Python");
		Thread.sleep(10000);
		select.selectByValue("java");
		Thread.sleep(10000);
		
		driver.quit();
		
		
	}

}
