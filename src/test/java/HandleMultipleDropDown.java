import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		driver.get("https://www..com/orangehrm.com/orangehrm-30-day-trial/");
		
		//Select noofEmpsdrp=new Select(driver.findElement(By.name("NoOfEmployees")));
		//noofEmpsdrp.selectByVisibleText("16-20");
		
		//Select industryDrp=new Select(driver.findElement(By.name("Industry")));
		//industryDrp.selectByVisibleText("Travel");
		
		
		//Select countryDrp=new Select(driver.findElement(By.name("Country")));
		//industryDrp.selectByVisibleText("Aruba");
		
		
		WebElement noOfEmpsELe=driver.findElement(By.name("NoOfEmployees"));
		selectOptionFromDropDown(noOfEmpsELe, "16 - 20");
		
		WebElement industryEle=driver.findElement(By.name("Industry"));	
		selectOptionFromDropDown(industryEle, "Healthcare");
		
		WebElement countryDrp= driver.findElement(By.name("Country"));		
		selectOptionFromDropDown(countryDrp, "Ghana");
		
	}	
		
		
	public static void	selectOptionFromDropDown(WebElement ele, String value)
	{	
		
		Select drp =new Select(ele);
		
		List <WebElement>alloptions=drp.getOptions();
		
		for(WebElement option:alloptions)
		{
			
			if(option.getText().equals(value))
				
			{
				 option.click();
				 break;
			}
			
			
			
			
		}
		
		// This is a generic method, we can use for mulitple drop down
		
	}
		
		
		
		
		
	

}
