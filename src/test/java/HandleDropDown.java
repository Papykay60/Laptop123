import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		
		WebElement drpCountryele=driver.findElement(By.id("input-country"));
		
		Select drpCountry =new Select(drpCountryele);
		//Method 1
		//drpCountry.selectByVisibleText("Tunisia");
		
		//Method 2 Select value, this will use value attribute.
		
		//drpCountry.selectByValue("3");  // Select Algeria
		
		
		// Method 3 select by index, index start from 0
		
		//drpCountry.selectByIndex(13); // Australia
		
		
		
		// How to select in another way without using Select Method
		
	   List<WebElement>	alloptions=drpCountry.getOptions();// This method is good for one dropdown only
	
	   for(WebElement option:alloptions)
	   {   
		  if(option.getText().contains("Cuba"))// once the element is selected
		  
		  {
			option.click();// we are clicking on the element.
			break;
		  }
		    
		   
		   
	   }
	   // This method is good for multiple dropdown, see package under src/test/java
	   
	   
	   
		
		
		

		
	}

}
