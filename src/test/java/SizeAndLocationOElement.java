import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOElement {
// video 27
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//To find the size and location of logo
		
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		//Location -method 1
		
		System.out.println("Location(x,y):" + logo.getLocation());
		System.out.println("Location(x):" + logo.getLocation().getX());
		System.out.println("Location(y):" + logo.getLocation().getY());
		
		//Method 2
		System.out.println("Location(x):" + logo.getRect().getX());
		System.out.println("Location(y):" + logo.getRect().getY());
		
		
		//To campture Size of element
		
		System.out.println("size(Width,Height):" + logo.getSize());

		System.out.println("size(Width):" + logo.getSize().getWidth());
		

		System.out.println("size(Height):" + logo.getSize().getHeight());
		
		//Size - Method 2

		System.out.println("size(Width):" + logo.getRect().getDimension().getWidth());

		System.out.println("size(Height):" + logo.getRect().getDimension().getHeight());

	}

}
