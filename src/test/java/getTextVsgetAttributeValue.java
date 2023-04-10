import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttributeValue {

	public static void main(String[] args) {
	
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromiumdriver().setup();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement emailinputbox=driver.findElement(By.id("Email"));
		//emailinputbox.clear();
		
		//emailinputbox.sendKeys("admin@yourstore.com");
		
		//capturing text from inputbox
		
		System.out.println("Result from getAttribute() method:"+ emailinputbox.getAttribute("value"));// attribute is derieved from element inspection
		System.out.println("Result from getText() method:"+ emailinputbox.getText());// You can only use get text
		//if admin@yourstore.com"is not present in html when u inspect ellement.
		
		// Example 2
		
		//WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		
		//System.out.println("Our attribute:" +button.getAttribute("class"));
		
		//System.out.println(button.getText());// can only get log in text becos is not in html of element
		
		WebElement title=driver.findElement(By.xpath("//div[@class='page-title']//h1"));
		
		System.out.println(title.getText());
		
		
	}

}
