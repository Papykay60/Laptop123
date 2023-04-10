import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopofWindowBrowser {
//Handle BrowserbPop up Window (using window handler)in selenium by Naveen
	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");//use this, when new chrome update do not
		// allow broswer to work with selenium, not to be use every time pls.
		WebDriver driver = new ChromeDriver(option);
		
		WebDriverManager.chromedriver().setup();
		
		driver.get("https://www.popuptest.com/goodpopups.html");// see You tube, this pop is coming 
		//from Browser not from application bcos the pop do not show element,this type of popup
		//normally have web address.
		// To perform any operation on Browser, u need to 1st make chnages to browser
		// To handle this we can use 1.Desired Capabilities from Selenium or
		// 2. Options from individual Browser
		// Use options becos browser relate individual browser not selenium
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//find the xpath of the link and click to allow popup.
		
		// where up show the webaddress as a webpage, like parent and child, find the use window id
	
	}

}
