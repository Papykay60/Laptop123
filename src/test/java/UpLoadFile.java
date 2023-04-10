import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpLoadFile {
//lecture 31 Uploading file, pavan
	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver(options);
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//driver.get("https://www.monsterindia.com/");
		driver.get("https://www.foundit.in/");
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		
		//Using sendkeys method
		
		//U can use sendkeys method where u find Type=file, in the html element of uploading tab
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\User\\OneDrive\\Documents\\AMIDA\\automationP.docx");
		
		//Using ROBO class methods
		//Click action failed to work, it gave "InvalidArgument Exception"
		
		
		WebElement button =driver.findElement(By.xpath("//input[@id='file-upload']"));
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",button);//click on the button
		
		//File open, then do the following 1. copy the path, 2. paste with CTRL + V, 3.click ENTER
		
		Robot rb =new Robot();
		rb.delay(2000);
		
		//put path to file in a Clipboard
		StringSelection ss =new StringSelection("C:\\Users\\User\\OneDrive\\Documents\\AMIDA\\automationP.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL + V
		rb.keyPress(KeyEvent.VK_CONTROL);// Press on CTRL key
		rb.keyPress(KeyEvent.VK_V);// Press on CTRL key
		rb.delay(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);// To release the pressed keys
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		
		//Press ENTER
		rb.keyPress(KeyEvent.VK_ENTER);// To release this presssed key
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		
		
		
		
	}

}
