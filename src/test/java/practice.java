import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	public static void main(String[] args) {
	   
		
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromiumdriver().setup();
		
		

	}

} 