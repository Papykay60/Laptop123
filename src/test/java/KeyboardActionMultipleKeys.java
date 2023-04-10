import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//25 Keyboard action
public class KeyboardActionMultipleKeys {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://text-compare.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.switchTo().frame(driver.findElement(By.id("_atssh857")));
		driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
		
		
	   WebElement input1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		
	   WebElement input2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		//send welcome to selenium to box 1 and copy it into the second box
	   
	   input1.sendKeys("Welcome to selenium");
	   
	   Actions act=new Actions(driver);
	   //Ctrl +  A
	   act.keyDown(Keys.CONTROL);
	   act.sendKeys("a");
	   act.keyUp(Keys.CONTROL);
	   act.perform();
	   
	   //Ctrl + C
	   act.keyDown(Keys.CONTROL);
	   act.sendKeys("c");
	   act.keyUp(Keys.CONTROL);
	   act.perform();
	   
	   //Tab-- To shift to second box(input 2 box)
	   act.sendKeys(Keys.TAB);
	   act.perform();
	   
	   //Ctrl
	   
	   act.keyDown(Keys.CONTROL);
	   act.sendKeys("v");
	   act.keyUp(Keys.CONTROL);
	   act.perform();
	   
	   //compare the text
	   
	   if(input1.getAttribute("value").equals(input2.getAttribute("value")))

           System.out.println("Text copied");
       
       else
    	   
    	   System.out.println("Text not copy");
		
		
		
		
		

	}

}
