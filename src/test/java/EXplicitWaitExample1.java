import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EXplicitWaitExample1 {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		WebDriverManager.chromedriver().setup();
		
	    driver.get("http://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='Accept all']")).click();
		
		
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[text()='WebDriver - Selenium']")).click();
		
		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='WebDriver - Selenium']")));

		element.click();
		
		
	}

}
