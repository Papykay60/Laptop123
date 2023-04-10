import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecuNaveenUtilities {
//Lecture 11- Highlight elements  using JavaScriptExecutor- Naveen AutomationLab
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		driver.manage().deleteAllCookies();//delete all the cookies
		driver.manage().window().maximize();// maximise all the cookies
		
		//dynamic wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://www.freecrm.com/");
		//driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
		WebElement loginBtn=driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("olakayjulius@yahoo.com");
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Lolade123!");
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
		
		 //executeScript-----to execute javascript code
		
		
		//WebElement homepg=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));
		
		//1.flash(loginBtn,driver);// flash shd be use for a specific element u want highlight
		
		
		//drawBorder(loginBtn,driver);//Good utility, draw a border on element e.g Login, if it failed or has bug 
		//2. You can then take screenshot and send it to developer
		//Take screenshot after borderdrawn
		
		
		//3. Take screenShot and store as a file format, remeber to refresh the project to see it.
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyfile //method
		FileUtils.copyFile(src, new File("/Users/User/eclipse-workspace/Julius 2023 workspace/Laptop123/src/test/java/default package/element.png"));
		
		//generate Alert
		//4.generateAlert(driver, "There is an issue with login button on login page");
	
		//5 click on any element by using JS executor
		
		//clickElementByJS(loginBtn,driver);
		
		//6. How to refresh a page
		//a. By selenium 
		
		//driver.navigate().refresh();
		
		//b. By JS executor
		
		//refreshBrowserByJS(driver);
		
		// 7.get the title of the page by JS
		//System.out.println(getTitleByJS(driver));
		
		//8.get the page text
		
		//System.out.println(getPageInnerText(driver));
		
		//9.scroll page down
		
		//scrollPageDown(driver);
		
		//10. To scroll page into view
		
		WebElement policy= driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		 scrollIntoView(policy, driver);
		
		
		
	} //Revist how to flash with JavascrpitExecutor??
	 public static void flash(WebElement element, WebDriver driver) {
			 
		 JavascriptExecutor js= ((JavascriptExecutor) driver);
		 String bgcolor = element.getCssValue("backgroundColor");// This will give background color of any element
		 for(int i=0;i<100;i++){
		 
			 changeColor("rgb(0,200,0)", element, driver);//first will change color to green
			 changeColor(bgcolor, element, driver);// Second it will get original color/default color
		 }
	 }
		
		
	 public static void changeColor( String color,WebElement element, WebDriver driver) {
		 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].style.backgroundColor = '"+color+"'", element );
		
		try {
			
			Thread.sleep(20);
		}   catch (InterruptedException e) {	
		}
			 
	 }
	 

	// This can help to but border on a element and color u want especially when element failed and u are sending it to developer.	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid green'", element);
	}
		
		
	public static void generateAlert(WebDriver driver,String message) {	
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
		
	}
		
		//we zero in the argument bcos only one element, which start from 0
	// we use it when page not loaded properly,stale element,element not visible
	public static void clickElementByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("argument[0].click();", element);
		
	}
		
	public static void refreshBrowserByJS(WebDriver driver) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("history.go(0)"); // first history	
	}
	
    public static String getTitleByJS(WebDriver driver) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
	    String title=js.executeScript("return document.title;").toString(); // first history	
	    return title;
    
    }	
	
	public static String getPageInnerText(WebDriver driver) {
		
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver)
	{	
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	//To scroll the page for you until element u want is visible
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}
