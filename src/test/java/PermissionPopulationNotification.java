import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
//Lesson 17
public class PermissionPopulationNotification {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver(options );
	    driver.get("http://www.redbus.in/");
		
		driver.manage().window().maximize();
	    Thread.sleep(3000);
		driver.navigate().refresh();

	}

}
