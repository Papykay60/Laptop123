import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// Video 29
public class HandlingCookies {
	

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
 //1. How to capture cookies from browsers
		
	Set<Cookie> cookies=driver.manage().getCookies();// Set<Cookie> is a predefined class or default name
	System.out.println("Size of cookies present:" + cookies.size());
		
//2.How to print cookies from browser?
	
	for(Cookie cookie:cookies)
	{
		System.out.println(cookie.getName()+ " : " +cookie.getValue());
		
	}
	
	
//3. How to add cookies to the browser
	
	Cookie cookieobj= new Cookie( "Mycookie1234", "arvby23nfykb");
	driver.manage().addCookie(cookieobj);
	
	
	cookies=driver.manage().getCookies();
	System.out.println("Size of cookies after adding new one:" + cookies.size());// 6
	
	
//4. How to delete specific Cookie from the browser?
	 driver.manage().deleteCookie(cookieobj);// 1st method
	 driver.manage().deleteCookieNamed("Mycookie1234");//2nd Method
	 cookies=driver.manage().getCookies();// Line 52 and 53 is to capture cookies left
	 System.out.println("Size of cookies after deletion:" + cookies.size());// 
	 
	 
//5. How to delete all the cookies from browser?
	 driver.manage().deleteAllCookies();
	 cookies=driver.manage().getCookies();// Line 58 and 59 is to capture cookies left
	 System.out.println("Size of cookies after deletion:" + cookies.size());// 
	 
	 
	 
	 
		
    driver.close();
	}

}
