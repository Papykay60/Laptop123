import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementvsFindElements {

	public static void main(String[] args) {
		
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		
		// findelement() ---->  Return the single WebElement
		
		 // Scenario 1
		WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		 searchbox.sendKeys("XYZ") ;
		 
		 // scenario 2----> whenever u use find element it will only find the first element, even if u have many elements
		 // when the element is not available in this case, it will throw no such element exception.
		 
		 //WebElement ele=driver.findElement (By.xpath("//div[@class='news-items']//a"));
		 //System.out.println(ele.getText());
		 
		 
		 //Scenario 1
		 // Find elements() will always return multiple web elemenents, you will always perform looping statement here.
		List<WebElement>links= driver.findElements (By.xpath("//div[@class='news-items']//a"));
		
		
		System.out.println("No of elements available:" +links.size());
		
		for(WebElement ele:links)
		{
			 System.out.println("my element:"   + ele.getText());
		}
		 
	
		
		 
		 
                           		 

	}

}
