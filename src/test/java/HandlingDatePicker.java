import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
// lecture 22
public class HandlingDatePicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		String year="2023";
		String month="July";
		String date="10";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();// open date picker
		
		while(true)
		{
		
		   String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();//month 
            //month and year that appeared when application was opened			
		   //to split febuary 2023 and each in each array
		   String arr[]=monthyear.split(" ");
		   String mon=arr[0];
		   String yr=arr[1];
		   
		   if(mon.equalsIgnoreCase(month) && yr.equals(year))// if the mon&year do not match july 2023 continue clicking.
           break;
		   
		   else
			   
			   driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		        
			   
		   }
		   //Date selection
		     
		  List<WebElement> alldates =driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr//td"));		   
		  
		  
		  for(WebElement ele:alldates)
		  {
			 
			  
			  String dt=ele.getText();
			  
			  if(dt.equals(date))
			  {
				  ele.click();
				  break;
			  }
			
			 
			 
		  }
		   
		   
		   
		}
	
	
		
		
		
		
		
	}


