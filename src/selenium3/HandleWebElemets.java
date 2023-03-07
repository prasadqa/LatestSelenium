package selenium3;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebElemets {

	public static WebDriver driver;
	public static final String url = "https://www.hyrtutorials.com/p/basic-controls.html";
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(5000);
		
		WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
		if(firstNameTextBox.isDisplayed()) {
			if(firstNameTextBox.isEnabled()) {
				firstNameTextBox.clear();
				firstNameTextBox.sendKeys("Ravi");
				
			}else {
				System.out.println("First name text box is not enabled");
			}
			
		}else {
			System.out.println("First name text box is not displayed");
		}
		Thread.sleep(3000);
		WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
		if(lastNameTextBox.isDisplayed()) {
			if(lastNameTextBox.isEnabled()){
				lastNameTextBox.clear();
				lastNameTextBox.sendKeys("sesham");
			}else {
				System.out.println("Last name text box is not enabled");
			}
			
		}else {
			System.out.println("Last name text box is not displayed");
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		WebElement maleRadioButton =driver.findElement(By.xpath("//input[@id='malerb']"));
		if(maleRadioButton.isDisplayed()) {
			System.out.println("male radio button: "+maleRadioButton.isSelected());
			if(!maleRadioButton.isSelected()) {
				
				maleRadioButton.click();
			}else {
				System.out.println("Male radio text box is selected");
			}
			
		}else {
			System.out.println("Male radio text box is not displayed");
		}
		Thread.sleep(3000);
		WebElement LanRadioButton =driver.findElement(By.xpath("//input[@id='englishchbx']"));
		if(LanRadioButton.isDisplayed()) {
			if(!LanRadioButton.isSelected()) {
				LanRadioButton.click();
			}else {
				System.out.println("Languages Radio button is not selected");
			}
			
		}else {
			
			System.out.println("Languages Radio button is not displayed");
		}
		Thread.sleep(3000);
		WebElement EmailTextBox = driver.findElement(By.id("email"));
		if(EmailTextBox.isDisplayed()) {
			if(EmailTextBox.isEnabled()){
				EmailTextBox.clear();
				EmailTextBox.sendKeys("seshamRavi@gmail.com");
			}else {
				System.out.println("Email text box is not enabled");
			}
			
		}else {
			System.out.println("Email text box is not displayed");
		}
		Thread.sleep(3000);
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		if(passwordTextBox.isDisplayed()) {
			if(passwordTextBox.isEnabled()){
				passwordTextBox.clear();
				passwordTextBox.sendKeys("seshamRavi@gmail.com");
			}else {
				System.out.println("Password text box is not enabled");
			}
			
		}else {
			System.out.println("Password text box is not displayed");
		}
		Thread.sleep(3000);
		WebElement registerbtn = driver.findElement(By.id("registerbtn"));
		if(registerbtn.isDisplayed()) {
			if(registerbtn.isEnabled()){
				registerbtn.click();
			}else {
				System.out.println("Password text box is not enabled");
			}
			
		}else {
			System.out.println("Password text box is not displayed");
		}
		Thread.sleep(3000);
		WebElement RegText = driver.findElement(By.xpath("//label[@id='msg']"));
		WebElement element = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(RegText));
		if(element.getText().equalsIgnoreCase("Registration is Successful"))
		{
			System.out.println("Text Passed");
		}
		
		
		driver.quit();

	}

}
