import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
        Actions act =new Actions(driver);
        
        act.sendKeys(Keys.BACK_SPACE).perform();
        
        Thread.sleep(3000);
        
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(3000);
        act.sendKeys(Keys.SPACE).perform();
        
        
        
        
        
        
        
        
	}

}
