import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrameWithParent {
//Lesson 18
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='accept-choices']")).click();
		driver.switchTo().frame("iframeResult"); // switch to outer frame
		driver.switchTo().frame(0); // switch to inner iframe
		
		
		
		System.out.println("Text present inside the inner frame:"+ driver.findElement(By.xpath("//h1")));
		
		driver.switchTo().parentFrame();// go to parent frame or outer frame
		
		WebElement text=driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]"));
		
		 System.out.println("Print the Message:"+text.getText());
		 
		//driver.findElement(By.xpath("/html/body/iframe"));
		
		
		
		
		
		
		
		
	}

}
