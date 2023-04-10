import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown_BingSearch {
// video 12
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	    
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("bnp_btn_accept")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("selenium");
		Thread.sleep(2000);
	    List <WebElement> list=driver.findElements(By.xpath("//li[@class=\"sa_sg\"]//span"));
	    Thread.sleep(2000); 
	    System.out.println("List of auto suggestion:"+list.size());
	
		//Alert btn =driver.switchTo().alert();
		
		//System.out.println(btn.getText());
		//Thread.sleep(2000);
		//btn.accept();
		
		
		
		
		for(WebElement listitem:list)
		{
			if(listitem.getText().equals("selenium benefits"))
			{
				listitem.click();
				break;
			}
				
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
