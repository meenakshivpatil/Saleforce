package Project.Saleforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class editTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(8000);
		WebElement ClickTask=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[5]"));
		((RemoteWebDriver) driver).executeScript("arguments[0].click();",ClickTask);
		
		driver.findElement(By.xpath("//force-highlights-icon//following::lightning-primitive-icon")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']/li[11]")).click();
		Thread.sleep(5000);
		
		WebElement Subject=driver.findElement(By.xpath("//span[text()='ss']"));
		((RemoteWebDriver) driver).executeScript("arguments[0].click();", Subject);
		
		driver.findElement(By.xpath("//button[@title='Edit Due Date']")).click();
		driver.findElement(By.xpath("//input[@class='inputDate input']")).click();
		driver.findElement(By.xpath("//input[@class='inputDate input']//following::span[contains(@class,'todayDate')]")).click();
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		
		//8. Select Priority as low
		driver.findElement(By.xpath("(//span[text()='Priority'])[2]//following::a[text()='Low']")).click();
		
		//9. Click save and verify Subject
		driver.findElement(By.xpath("//span[text()='Save']")).click();
	

	}

}
