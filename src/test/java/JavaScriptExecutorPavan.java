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

public class JavaScriptExecutorPavan {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//drawBoarder
	//1.Draw border and take screenshot	
		
		/*WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtils.drawBoarder(logo, driver);
		
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshot\\logo.png");
        FileUtils.copyFile(src, trg);*/
                
	
	//2. Getting the page title
		
		/*String title=JavaScriptUtils.getTitleByJS(driver);
		System.out.println(title);*/ 
		
	//3.click action
		
     /* WebElement ele=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
	  JavaScriptUtils.clickElementByJS(ele, driver);*/	
		
	//4.GenerateAlert
		
	/*	JavaScriptUtils.generateAlert(driver, "This is my Alert");*/
		
		
	//5. Refreshing the page
		
		/*JavaScriptUtils.refreshBrowserByJS(driver);*/
		
		
	//6. Refreshing the page down
		
		/*JavaScriptUtils.scrollPageDown(driver);
		
		Thread.sleep(4000);
		
	//7. scroll the up the page
		
		JavaScriptUtils.scrollPageUp(driver);
		
		
	//8. Zoom page
		
		.zoomPageByJS(driver);*/
		
	//9.
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtils.flash(logo, driver);
		
		
		
		
		
	}

}
