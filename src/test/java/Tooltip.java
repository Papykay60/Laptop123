import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//video 27
public class Tooltip {
	//Tooltips can be attached to any element. When you hover the element with your mouse, 
	//the title attribute is displayed in a little box next to the element, just like
	//a native tooltip.

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().frame(0);
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='age']"));
		
		String tooltiptext=inputbox.getAttribute("title");
		
		System.out.println("Tooltiptext printed out:" + tooltiptext);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
