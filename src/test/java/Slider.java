import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {
//24
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://jqueryui.com/slider/#range");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//driver.switchTo().frame("demo-frame");
	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		/*WebElement Min_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		System.out.println("Location of Min slider:" +Min_slider.getLocation());//(79, 46)

		System.out.println("Height and width of element:" +Min_slider.getSize());//(20,20)
		
		Actions act= new Actions(driver);
		act.dragAndDropBy(Min_slider, 200, 0).perform();*/
	
		// Our intention is to move sllider towards X axis not Y
		
		WebElement Max_Slider=driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		
		System.out.println("Location of Max slider:" +Max_Slider.getLocation());//((318, 46))

		System.out.println("Height and width of element:" +Max_Slider.getSize());//(20,20)
		
		Actions actn= new Actions(driver);
		actn.dragAndDropBy(Max_Slider, 100, 0).perform();// use for sliding
	
		Thread.sleep(3);
		
		//example 3
		actn.dragAndDropBy(Max_Slider, -100, 0).perform();
		
		
		
	
		
	}

}


