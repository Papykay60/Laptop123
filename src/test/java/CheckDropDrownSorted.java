import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

// see video part 11: selenium with java tutorial | practical interview

// Original list and temp list consist same item from drop down

//Sort out templist then we get sorted temp list, then compare it with original list, if equals then we can say
//list is SORTED,But if not equals we say list is UNSORTED. Note o

public class CheckDropDrownSorted {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		Thread.sleep(10);
		WebElement drpElement= driver.findElement(By.name("category_id"));
		Select drpselect=new Select(drpElement);
		
		
		List <WebElement>options=drpselect.getOptions();
		
		ArrayList originallist=new ArrayList();
		ArrayList templist=new ArrayList();
		
		
		
		for(WebElement option:options)
		{
			originallist.add(option.getText());
			templist.add(option.getText());
		}
		
		System.out.println("Original list:"+originallist);
		System.out.println("Temp list:"+templist);
		
		Collections.sort(templist); //sorting 
		
		Thread.sleep(10);
		System.out.println("Original list:"+originallist);
		System.out.println("Temp list After sorting:"+templist);
		
		if(originallist.equals(templist))
		{
		   
			System.out.println("Drop Down sorted");
		}
		else
		{
			System.out.println("Drop Down unsorted");
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}