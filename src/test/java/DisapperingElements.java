import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisapperingElements {
// Method 1. When u click on drop to inspect, the display but while trying inspect the 
	// element the drop down disapper.
	//Let's Kode it -YOU TUBE/UDEMY
//Type this in the console to freeze the page, then type - setTimeout(function() {debugger;}, 3000);
// Hit enter, before of 6seconds u give u must type d word u are searching for. Then page freeze.
	// when you finish, click top of page, the where "paused debugger" appear
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//METHOD 2
		// type and bring word you want to inspect from the list of dropdown
		//click and try to inspect the any element from developer tool by click on any element.
		// From window operating system, from keyboard hold: ctrl+shift+p and it will bring run dialogue
		// From Mac keyborad hold: cmd + shift + p, run dialogue will be display
		
		// Infron of RUn> type"focus", it will bring dialogue box, then click on "Emulate a focus page"
		// That is second options
		
	// The element will not disappear again but fix to allow u to inspect.
		
		
		
		
		
		
		
	}

}
