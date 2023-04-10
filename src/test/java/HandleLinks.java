import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.asda.com/");
		
		driver.manage().window().maximize();
	
		
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		
		
	    //WebDriverWait wait = new WebDriverWait(driver,10);
	    //wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
	    
	    Thread.sleep(3000);
	   //WebElement cookies1= new WebDriverWait(driver, Duration.ofSeconds(10))
	           //.until(ExpectedConditions.elementToBeClickable(By.xpath("cookies")));
	    
	    
	    
	    Thread.sleep(2000);
		
		//driver.findElement(By.linkText("Valentine's Day")).click();
		driver.findElement(By.partialLinkText("Day")).click();
		
		//How to capture all links on the Webpage. anchor tag i.e "a" wiil help us
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links on the page:" + links.size());
		
		
		//Normal loops
		
		/*for(int i=0;i<links.size();i++)
		{
			links.get(i).getText();
			
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}*/
		
		for(WebElement link:links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
		

		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
