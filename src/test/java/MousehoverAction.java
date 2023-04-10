import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MousehoverAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.opencart.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement desttopsmenu=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		
		WebElement destmenuitem= driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions act =new Actions(driver);
		act.moveToElement(desttopsmenu).moveToElement(destmenuitem).click().perform();
		
		
		
		

	}

}
