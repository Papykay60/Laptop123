import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDatePickerMethod2 {
// lecture 22
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='dob']")).click(); // open date picker
		
		//month selection
		Select month_drpdn= new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		
		month_drpdn.selectByVisibleText("Oct");
		
		// year selection
		Select year_drpdn= new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		
		year_drpdn.selectByVisibleText("1990");
		
		
		String date= "15";
		// Date sele3ction
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));
		
		for(WebElement ele:alldates)
		{
			
			String dt=ele.getText();
			
			 if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
		
		
		
		
		
		
		
		

	}

}
