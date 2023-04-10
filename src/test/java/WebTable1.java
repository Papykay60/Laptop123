import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/* 1) How many rows in the table
 * 2) How many columns in the table
 * 3)Retrieve the specific row/column data
 * 4)Retrieve all the data from the table
 * 5) Print Release date, versionNo of java language of selenium
 * 
 */

//Lesson 20
public class WebTable1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2250)");
		
	// 1. How many no of rows in the table
	
		int rows=driver.findElements(By.xpath("/html/body/div/main/div[6]/div/table/tbody/tr")).size();
		
		System.out.println("Print total no of rows:" + rows);
		
		// How many no of columns in the table
		
		
		int cols =driver.findElements(By.xpath("//body[1]/div[1]/main[1]/div[4]/div[1]/table[1]/thead[1]/tr[1]/th")).size();		
		
		System.out.println("print no of columns:"+ cols);
		
		// 3. Retrieve specific row and column
		
		//value=/html/body/div/main/div[6]/div/table/tbody/tr[1]/td[3]
		
		String value=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table/tbody/tr[2]/th[1]")).getText();
		
		System.out.println("print the value:"+ value);
		
		
		// 4. Retrieve all the data from the table
		
		
		for(int r=1;r<=rows;r++)
		{
			
			for(int c=1;c<=cols;c++)
			{
				
				String data=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table/tbody/tr["+r+"]/th[1]")).getText();
				System.out.println(data+  "   ");
				
			}
			System.out.println();
		
			
			
		
			// The problem with this table element of the first column of the first row i.e th, is different from the
			// from other element i.e td
		}
		
		
		// To another table for practice
		
		
		
		driver.close();
		
		
		
		
		
	}

}
