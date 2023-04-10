import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJQueryDropdown {

	public static void main(String[] args) {
		// video 10

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		driver.get("http://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]")).click();
		//Method one
		
		//selectChoiceValues(driver,"choice 1"); 
		
		selectChoiceValues(driver, "choice 2", "choice2 3", "choice 6", "choice 6 2 1", "choice 6 2");
		
		//selectChoiceValues(driver,"all");
		
		//Mthod to select all choices
		
		//String value-- can hold only single value
		// String...value ---This can hold multiple value
	}

	

	
	public static void selectChoiceValues(WebDriver driver, String...value) {
		
		List<WebElement>choicelist= driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			
			for(WebElement item:choicelist)
			{
				
				String text=item.getText();
				
				for(String val:value)
				{
					
					if(text.equals(val))
						
					{
						item.click();
						break;
					}		
						
			}		
				
						
		}
			
	} 
		else
		{
			
			try
			{
			
			   for(WebElement item:choicelist)
			   {	
			       item.click();	
			   }
				
			
			}
			catch(Exception e)
			{
				
			}
		}
	}	
		
}