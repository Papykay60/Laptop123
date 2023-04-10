import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropDown {

	public static void main(String[] args) throws InterruptedException {
		//video 13, u cannot inspect element under this topic
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	    
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		Thread.sleep(2000);
		WebElement searchbox=driver.findElement(By.id("autocomplete"));
		searchbox.clear();
		Thread.sleep(2000);
		
		searchbox.sendKeys("Toronto");
		Thread.sleep(2000);
		String text;
		
		
		
		do
		{
			
			searchbox.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			text= searchbox.getAttribute("value");
			
			if(text.equals("Toronto, OH, USA"))
			{
				searchbox.sendKeys(Keys.ENTER);
				break;	
			}
			
			Thread.sleep(2000);	
		}while(!text.isEmpty());
		
		
	}	
		
		
		
			
		

	}


