import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	public static void main(String[] args) {
		
		String location= System.getProperty("user.dir")+ "\\download\\";
		
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		
		EdgeOptions options= new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(options);
		
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		//driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
		driver.findElement(By.xpath("//td[@class=\"text-right file-link\"]//a[@href=\"https://file-examples.com/wp-content/uploads/2017/02/file-sample_100kB.doc\"]")).click();
		
		
		
	}

}
