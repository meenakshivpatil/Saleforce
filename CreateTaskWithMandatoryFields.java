package Project.Saleforce;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateTaskWithMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver;
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver = new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
			Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(6000);
				
		WebElement elementTask = driver.findElement(By.xpath("(//span[text()='Tasks'])"));		
		driver.executeScript("arguments[0].click();", elementTask);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Tasks']//following::lightning-icon")).click();
		Thread.sleep(5000);
		
		
		  //6) Click New Task and 7) Enter subject as "Bootcamp "
		 driver.findElement(By.xpath("//span[text()='New Task']"));
		 driver.executeScript("arguments[0].click();",
		 driver.findElement(By.xpath("//span[text()='New Task']")));
		//  driver.findElement(By.xpath("//label[text()='Subject']/following::input")). sendKeys("Bootcamp Created by Meenakshi");
		 
		
		// 8) Select Contact from DropDown	
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("(//li[contains(@class,'lookup__item')])[1]")).click();
		
		driver.findElement(By.xpath("//span[@id='quickTextKeyboardTip']/following::textarea")).sendKeys("SALES FORCE Automation Using Selenium");
		//Save the task
		driver.findElement(By.xpath("//span[text()='Save']")).click();
				
		//10) verify the 'Error message' message
		//driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).click();
		
		WebElement errMsg = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']"));
		String Message = errMsg.getText();  
		System.out.println(Message);
				
		  if (Message.equals("Review the errors on this page."))
		  {
			  System.out.println("TC CreateTask with mandatory fields Passed");
		  
		  } else 
		  { 
			  System.out.println("TC CreateTask with mandatory fields Failed");
		  
		  }
		 
	}

}
