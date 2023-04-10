import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUpDisableHYRtutorial2 {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");//use this, when new chrome update do not
		// allow broswer to work with selenium, not to be use every time pls.
		WebDriver driver = new ChromeDriver(option);
		option.addArguments("disable-notifications");// use if it is Notification pop up
		option.addArguments("disable-geolocation");// use this for location pop up
		option.addArguments("disable-media-Stream");// use for camera or micphone popup
		WebDriverManager.chromedriver().setup();
		
		driver.get("https://www.Cleartrip.com/");// see You tube, this pop is coming 
		//from Browser not from application bcos the pop do not show element,this type of popup
		//normally have web address.
		// To perform any operation on Browser, u need to 1st make chnages to browser
		// To handle this we can use 1.Desired Capabilities from Selenium or
		// 2. Options from individual Browser
		// Use options becos broswer relate individual browser not selenium
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	
	}
	}


