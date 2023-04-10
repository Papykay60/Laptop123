import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
// Rahul -drag and drop
public class MouseDragandDropAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
	    
	    
	    // To know the number of iframe in an application
	     WebElement ele=driver.findElement(By.tagName("iframe"));
	    System.out.println(ele.getSize());
	    Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='/resources/demos/droppable/default.html']")));
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']//p"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		
		a.dragAndDrop(source, target).perform();
		
		
		
		
		
		
		driver.quit();

	}

}
