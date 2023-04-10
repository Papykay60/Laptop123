import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {
// Vide30, the web url is substituted, the original web contain cross origin frame, that gave me problem to find locators
	public static void main(String[] args) throws InterruptedException {
		
		String location=System.getProperty("user.dir")+ "\\Downloads\\";
		
		//Chrome
		
		HashMap preferences=new HashMap();
		preferences.put("download.default_directory", location);
				
		FirefoxOptions options=new FirefoxOptions();
		options.setExperimentalOptions("prefs", preferences);
		
		
		WebDriver driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		driver.get("https://techloris.com/lp/uk/errors1.php?");
		//driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	
	
		driver.findElement(By.xpath("//a[@class='right download2']")).click();
		// Thread.sleep(3000);
		
		//TO COMPLETE THIS LECTURE
		
		
	}

}
