import java.time.Duration;
import java.util.List;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {
// video 14
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	    
		driver.get("https://itera-qa.azurewebsites.net/home/automation/");
		driver.manage().window().maximize();
		
		
		//1.driver.findElement(By.xpath("//input[@id='monday']")).click();// to select monday
		
		
		//2.To select all text boxes, then we need to have xpath to select all text boxes
		// look for common attributes that can be use for xpath that can fit all textboxes
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id, 'day')]"));

		System.out.println(" No of checkboxes:"+ checkboxes.size());
		
		// 1. method using for...each loop
		/*for(WebElement Cboxes:checkboxes)
		{
			if(Cboxes.getText().contains("day"));
			Cboxes.click();
			
			
		}*/
		
		// 2,method or
		
		/*for(WebElement chboxes:checkboxes)
		{
			chboxes.click();
		}
		*/
		
	 // Using for loop
		
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		*/
		
		// 3 .How to select multiple check boxes by choice
		// To select monday and sunday
		
	/*	for(WebElement chbox:checkboxes)
		{
			
			String checkboxname=chbox.getAttribute("id");
			
			if(checkboxname.equals("monday") || (checkboxname.equals("sunday")))
			{
			     chbox.click();      
				
			}
		*/	
			
			
		
			
			//4. select the last 2 boxes out of 7 boxes
			// 0 1 2 3 4 5 6  i.e to select no 5 and 6, (7-2)
			//total no of check boxes- no of check boxes want to select = starting index is 5
			// 7-2 =5 bcos for loop will add 1 to it
			
			
			int totalcheckboxes=checkboxes.size();
			
			/*for(int i=totalcheckboxes-2;i<totalcheckboxes;i++)
			{
				checkboxes.get(i).click();
			}
			*/
			
		
		
		
		
		// To select the first 3 check boxes
	
	
	    for(int i=0; i<totalcheckboxes; i++)
	    {
	    	if(i<3)
	    	
	    	
	    	checkboxes.get(i).click();
	    }
		
		
	
	}
	}
	

