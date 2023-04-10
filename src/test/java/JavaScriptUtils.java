import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//They are user defined method
public class JavaScriptUtils {
// video 28 Pavan
	public static void drawBoarder(WebElement element, WebDriver driver) {
		JavascriptExecutor js =((JavascriptExecutor)  driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String title=js.executeScript("return document.title;").toString();
		return title;	
	}
	
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js =((JavascriptExecutor) driver);
		js.executeScript("alert('" + message+"')");
	}
	
	
	public static void refreshBrowserByJS(WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript("return Document.Title;");
	
	}
	
	
	public static void scrollPageDown(WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");// from top to down
		
	}
		
	public static void scrollPageUp(WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");//from bottom to Top of page
			
	}
		
	public static void zoomPageByJS(WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript("document.body.style.zoom='150%'");// zoom out by100%
			
	}
	
	public static void flash(WebElement element, WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	 String bgcolor = element.getCssValue("backgroundColor");
	 for (int i=0;i<50; i++) {
		 changeColor("#000000", element, driver);//1
		 changeColor(bgcolor, element, driver);//2
		 
	 }
	 
	}
		 
	public static void changeColor(String color, WebElement element,WebDriver driver) {
	JavascriptExecutor js =((JavascriptExecutor) driver);
	js.executeScript(" arguments[0].style.backgroundColor ='" + color + "'", element);// zoom out by100%
	
	try {
		Thread.sleep(20);
	
	}catch(InterruptedException e) {
	}	
	
	
	
	
	
	
	}	 
		 
		 
		 
		 
				 
		 


{
		 
		 
		 
		 
	 }
	 
	 
	}
		
	
	
	
	
	
	
	

