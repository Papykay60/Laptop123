import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authenticatedpopup {

	public static void main(String[] args) {
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    //
		driver.manage().window().maximize();
		
		//syntax to use is to join Username and password with url
		//http://admin:admin@the-internet.herouapp.com/basic_auth
		//http;//user:password@URL
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		
		
	}
	

}
