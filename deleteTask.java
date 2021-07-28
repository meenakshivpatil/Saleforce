package Project.Saleforce;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
		
		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(8000);
		//4. Click on Tasks tab
		WebElement ClickTask=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[5]"));
		((RemoteWebDriver) driver).executeScript("arguments[0].click();",ClickTask);
		//5.Click on Dropdown icon available under tasks and select value as Recently viewed
		
		driver.findElement(By.xpath("//force-highlights-icon//following::lightning-primitive-icon")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
		
		driver.findElement(By.xpath("//input[starts-with(@class,'slds-input default input ')]")).click();
				
		  
		  driver.findElement(By.xpath("//a[@title='Show 13 more actions']")).click();
		  driver.findElement(By.xpath("//a[@title='Delete']")).click();
		  driver.findElement(By.xpath("//span[text()='Delete']")).click();
		  
		    	  
		
		  //10) Save and verify the 'Task deleted' message 
		  WebElement msg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		  String Taskname = msg.getText();
		  System.out.println("Taskname=>"+ Taskname);
		  int startQuote=0;
		  String undoMsg = "A ";
		  for (int i=0;i<Taskname.length();i++) {
			
			  if (startQuote==0 && Taskname.charAt(i)=='\"') {
				  startQuote=1;
			  } else if (startQuote==1 && Taskname.charAt(i)=='\"' ){
				  startQuote=0;
				  continue;
			  }
			  if (startQuote == 0) {
				  undoMsg+=Taskname.charAt(i);
			  }
		  }
		//  String undoMsg = Taskname.replaceFirst("\".*\"", "");
		  System.out.println("undoMsg =>"+undoMsg);
		
		 
		
		  if (undoMsg.equals("A Task  was deleted. Undo"))
		  {
		  System.out.println("TC Create Task Passed");
		  
		  } else
		  { System.out.println("TC Create Task Failed");
		  
		  }
		 
		 
		 driver.close(); 
		 
	}

}
