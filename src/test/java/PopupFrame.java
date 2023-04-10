import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupFrame {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Integer> conentSettings = new Ha	options.addArguments("--remote-allow-origins=*");shMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String,Object>();
		HashMap<String, Object> prefs= new HashMap<String, Object>();
		
		
		//conentSettings.put("media_stream", 1);
		
		//conentSettings.put("geolocation", 2);// change the number 0;1;2 as below
		
	   conentSettings.put("Ad", 2);// 0 is Ask(Default);1. is Allow; 2. is Block
		// Note: it will change the browser either to allow popup or allow popup
	    profile.put("managed_default_content_settings", conentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		
	//use this, when new chrome update do not
		// allow broswer to work with selenium, not to be use every time pls.
		WebDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		driver.get("https://filesamples.com/formats/pdf");
		driver.findElement(By.id("ez-accept-all")).click();
		

	}

}
