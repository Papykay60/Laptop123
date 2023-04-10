import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Statusofwebelement {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//IsDisplayed()  isEnabled()
		
		//FROM PAVAN YOU TUBE (SELENIUM WITH JAVA TUTORIALS AND PRACTICAL INNTERVIEW UQESTIONS NUMBER 4
		
		
		WebElement searchstore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		
		  // We can use this for all kind of element  
		 
		System.out.println("The element is displayed:" + searchstore.isDisplayed());// true 
		
		System.out.println("The element is displayed:" + searchstore.isEnabled());// true   
	
		// isSelected  -- we can use this for radio button, check boxes or drop down and it returns boolean value of true or false
		
		
		//I want to check whether radio button is selected or not.
		
		WebElement male =driver.findElement(By.xpath("//input[@id='gender-male']"));
		
		WebElement female =driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println(female.isSelected());//false
		System.out.println(male.isSelected());//false
		
		male.click();// Male radio button is selected
		
		System.out.println(male.isSelected());//true
		System.out.println(female.isSelected());//false
		
		female.isSelected();// Female radio button is selected
		
		System.out.println(female.isSelected());//true
		System.out.println(male.isSelected());//false
	}

}
