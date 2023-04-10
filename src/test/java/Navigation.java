import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {
		
		//LECTURE 5 PAVAN SELENIUM WITH JAVA TUTORIAL
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.snapdeal.com/");
		//driver.get("http://www.amazon.com");
		
		driver.navigate().to("http://www.amazon.com");// This can be use instead of get(url)
		
		driver.navigate().back();// To snapdeal 
		driver.navigate().forward();// To amazon
		
		driver.navigate().refresh();// refresh/reload the page
		
		
		
		
	

	}

}
