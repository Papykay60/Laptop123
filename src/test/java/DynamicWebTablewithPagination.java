import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

// Lesson 21 to be revisted.
public class DynamicWebTablewithPagination {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/admin/index.php?");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		WebElement username =driver.findElement(By.xpath("//input[@type='text']"));
		username.clear();
		username.sendKeys("demo");

		WebElement password =driver.findElement(By.xpath("//input[@type='password']"));
		password.clear();
		password.sendKeys("demo");


		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000); 

		driver.findElement(By.xpath("//div[@class='modal-header']//button[@class='btn-close']")).click();

		//Sales--->Order

		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

		//Table

		// 1. Find the total number of pages in the table

		String text=driver.findElement(By.xpath("//form[@id='form-order']/div/div[2]")).getText();
		System.out.println(text);


		//we need to use 2 java method i.e indexOf() and subString(), we start from beging of bracket i.e "(" and use end of bracket
		//use variable to store the code i.e text
		//text.indexOf ("(")
		//text.indexOf("Pages")
		// . We will use text.substring, index start index from 0 then will be +1 for start . then -1 for the end index.
		
		int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));

		System.out.println("total number of pages:"+total_pages);
		Thread.sleep(1000);

		//We need to click on every page and count the number of rows there.
		// active page has "span" tag when click on page, is better use our xpath to avoid failure in future

		//active_pages.click();

		for(int p=1;p<=5;p++)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			WebElement active_pages =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("///ul[@class=\"pagination\"]//li//span/ul[@class='pagination']//li//span")));
			active_pages.click();
			
			//WebElement active_pages=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			
			System.out.println("Element for active page:" + active_pages.getText());
			
			Thread.sleep(3000);
			//active_pages.click();

			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			System.out.println("No of rows present on the first page:" +rows);

			Thread.sleep(3000);
			
			
			String pageno=Integer.toString(p+1);
			
			WebElement pages=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']")));
			pages.click();
			
			//WebElement pages=driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageno+"']"));//xpath to point to each pages.

		}       //ul[@class="pagination"]//li//a[text()='6']




		/*JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']//li//span")));

		element.click();*/

       ////body/div[@id='container']/div[@id='content']/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/ul[1]/li[1]/span




	}

}
