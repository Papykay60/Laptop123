import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inneriframe {
// lesson 18
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://demo.automationtesting.in/Frames.html");
		
		driver.manage().window().maximize();
		
		//get xpath of element where no id or name of element is not present in html
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		Thread.sleep(3000);
		WebElement outerframe=driver.findElement(By.xpath("//*[@id='Multiple']/iframe "));
		driver.switchTo().frame(outerframe); //Here we are passing frame as a webelement
		
		//use frame xpath not relative xpath
		WebElement innerIframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		Thread.sleep(3000);
		driver.switchTo().frame(innerIframe);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("welcome");
		
		
		//we dont need defaultcontent(),bcos we move from one frame to another
		
		
		
		
		
		
		
		
	}

}
