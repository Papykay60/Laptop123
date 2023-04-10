import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.Strings;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtablePagination2 {
//How to handle pagination in selenium webdriver|how to handle dynamic webtable by Krishna Sakinala
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://databases.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		int paginationsize =driver.findElements(By.cssSelector("#example_paginate>span>a")).size();
		
		List<Strings>names= new ArrayList<Strings>();
		
		for(int i =1; i<= paginationsize;i++)
		{
			
			String paginationSelector= "#example_paginate>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(paginationSelector)).click();
			List<WebElement> namesElements=driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
			
			for(WebElement namesElement : namesElements)
			{			
				names.add(namesElement.getText());
				
				
			}
			
		}
		
		for(String name:names) {
			System.out.println(name);
		}
		
		int totalNames= names.size();
		System.out.println("Total Number of Names :" + totalNames);
		
		String displayedCount=driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total Number of Displayed Names count:" + displayedCount);
		
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
		

	}

}

