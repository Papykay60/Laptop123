import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {
// lecture/video 26
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Full page screenshot,  driver is instance variable of webdriver driver as ts is to Takescreenshot
		// Webdriver is an interface,RemoteWEbdriver is a class, that implements methods from webdriver and Javascript executor
		// Takescreenshot is also an interface and it contains methods, Remotewebdriver as a class also implemts mthod from Takescreenshot
		// RemoteWebdriver contain implemented methods and this same method are passed to the following classes
		// chromeDriver,FirefoxDriver,EdgeDriver,SafariDriver,and ChromeDriver
		// if you use webDriver driver=new ChromeDriver(),u will need to typecast Takescreenshot,bcos Takescreenshot is an interface
		
		
		/*TakesScreenshot ts =(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);// this will save screenshot in the computer
		File trg=new File(".\\screenshots\\homepage.png");//but want it save here
		
		FileUtils.copyFile(src, trg);//it will help copy our destination*/
		
		
		
		
		//Capture screenshot a section of a page
		// First find the element of the area
		
		/*WebElement section=driver.findElement(By.xpath("//body/div/div/div/div/div/div/div[4]"));
	    File src=section.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\featureproducts.png");
		
		FileUtils.copyFile(src, trg);*/
		
		//Campture screenshot an element(Logo)
		
		WebElement ele=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	    File src=ele.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\logo.png");
		
		FileUtils.copyFile(src, trg);
		
		
		
		
		driver.close();
		
		
		
		
		
		

	}

}
