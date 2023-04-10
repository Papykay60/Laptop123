import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//getwindowHandle()---will return single id of window
		//getwindowHandles()-- will return id of many windows
		
		
		
		//1. getWindowHandle()
	
		 //String windowID=driver.getWindowHandle();// return ID of the single browser window
		 //System.out.println(windowID);  // CDwindow-1DB9E09E6B7E07DB61C505935293E888
		 Thread.sleep(6000);
         driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
         driver.manage().deleteAllCookies();
         
         //open another browser
         //child window
         Thread.sleep(0200);
         
         Set<String> windowIDs=driver.getWindowHandles();// return ID's of multiple browser windows
         
         // First method - iterator()
         
         Iterator<String> it =windowIDs.iterator();
         
         Thread.sleep(3000);
         
         String parentWindowID=it.next();
         String childwindowID=it.next();
         
         System.out.println("parent Window ID:"+parentWindowID);
         System.out.println("child Window ID:"+childwindowID);
         
         //Second Method-- using List/ArrayList
         
         List<String> windowIDsList=new ArrayList(windowIDs);
         
         /*String parentwindowID= windowIDsList.get(0);// parent window id
         String windowchildID= windowIDsList.get(1); // Child window id
         
         System.out.println("parent window ID:" + parentwindowID);
         System.out.println("child window ID:" + childwindowID);
         
         
         // How to use window ID's for switching purposes
         
         driver.switchTo().window(parentwindowID);
         System.out.println("parent window title:" +driver.getTitle());// OrangeHRM
         
         driver.switchTo().window(childwindowID);
         System.out.println("child window title:" +driver.getTitle()); //child window title:HR Management System | HR
         */
         
         
        // For each loop 
         
        /* for(String windid:windowIDsList)
         {
        	//System.out.println(winid);
        	 
        	 String title=driver.switchTo().window(windid).getTitle();
        	 System.out.println(title);	 
        	 
         }
         driver.close(); //Will close the single window
         driver.quit();  //close all the browser windows*/
         
         
         for(String winid:windowIDsList)
         {
        	
        	 String title= driver.switchTo().window(winid).getTitle();
        	 if(title.equals("OrangeHRM"))

        	 {
        		 
        		 driver.close();
        	 }
        	 
        	 
        	 
         }

         
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
