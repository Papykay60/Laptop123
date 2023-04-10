import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
// How to handle Permission Pop ups using Selenium Webdriver by HYR Tutorials
public class PopUpAllowORDismiss {
//Permission Popup can be dealth with in 3 ways, 1. remove it,2,Click on allow button
	// 3. Click on block biutton
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String,Object>();
		HashMap<String, Object> prefs= new HashMap<String, Object>();
		
		
		conentSettings.put("media_stream", 1);
		
		//conentSettings.put("geolocation", 2);// change the number 0;1;2 as below
		
	   // conentSettings.put("notification", 2);// 0 is Ask(Default);1. is Allow; 2. is Block
		// Note: it will change the browser either to allow popup or allow popup
	    profile.put("managed_default_content_settings", conentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		
		options.addArguments("--remote-allow-origins=*");//use this, when new chrome update do not
		// allow broswer to work with selenium, not to be use every time pls.
		WebDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		driver.get("https://mictests.com");
		
		//driver.get("https://whatmylocation.com/");
		//driver.get("https://www.Cleartrip.com/");// see You tube, this pop is coming 
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
		
		Thread.sleep(6000);
		
		driver.findElement(By.id("mic-launcher")).click();
		

	}

}
