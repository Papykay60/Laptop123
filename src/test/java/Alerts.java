import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 // Lecture 17
public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		
		//Alerts with Ok button
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();*/
		
		
		//Alert window with two buttons-- ok and cancel button
		
		//driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		
		//driver.switchTo().alert().accept(); // close alerts
		
		//driver.switchTo().alert().dismiss(); //close Alert with cancel button
		
		
		//Alert window with input box
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		Alert Windowalert=driver.switchTo().alert();
		System.out.println("Alert message"+Windowalert.getText());
		
		Windowalert.sendKeys("welcome Kay");
		Windowalert.accept();
		
		
		
		
		
		
		
		
		
		
		

	}

}
