import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;
//lesson 19
public class GenericMethodofFulentWaitExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		
		driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='Accept all']")).click();


		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		By elelocator=By.xpath("//h3[normalize-space()='WebDriver - Selenium']");

		waitForElementWithFluentWait(driver,elelocator);

	}
	
	
	
	public static WebElement waitForElementWithFluentWait(WebDriver driver,  final By locator) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);


        // usage of Fluent wait
		WebElement element =wait.until(new Function <WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);

			}

		}); 

		return element;









	}

}
