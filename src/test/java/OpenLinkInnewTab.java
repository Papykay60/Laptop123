import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//27, How to open a new link in a new Tab
public class OpenLinkInnewTab {
//open a link from the main window
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).sendKeys(tab);
		
		
		
		
		
		
		
		

	}

}
