import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
// lecture 23
public class MouseDoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(3000);
		driver.findElement(By.id("accept-choices")).click();
		
		driver.switchTo().frame("iframeResult");
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Welcome to selenium");
		
		WebElement button= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		 
		Actions act =new Actions(driver);
		act.doubleClick(button).perform(); // No need of build, it is already in the perform	

		
		driver.quit();
	}

}
// stop on 14.41 and to continue from here