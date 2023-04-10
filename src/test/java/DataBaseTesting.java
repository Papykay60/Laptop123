import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
// jbdc import is necessary to do database testing, is not here
public class DataBaseTesting {
//See video 32 pavan selenium javan
	public static void main(String[] args) throws SQLException {
		
		// Data
		
		String cust_firstname = "John";
		String cust_lastName="Kenedy";
		String cust_email = "john@gmail.com";
		String cust_telephone="1234567890";
		String cust_password = "john123";
		
		//User Registration
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver(options);
	    
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//driver.get("https://localhost/opencart/upload/");url cannot work here

		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		
		driver.findElement(By.name("firstname")).sendKeys(cust_firstname);
		driver.findElement(By.name("lastname")).sendKeys(cust_lastName);
		driver.findElement(By.name("email")).sendKeys(cust_email);
		driver.findElement(By.name("telephone")).sendKeys(cust_telephone);
		driver.findElement(By.name("password")).sendKeys(cust_password);
		driver.findElement(By.name("confirm")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//verify whether message is correct
		try
		{
		String confmsg= driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		
		
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			System.out.println("Registration successful from Apllication");
		}
		else
		{
			System.out.println("Registration not successful from Apllication");
		}
		}
		catch(Exception e)
		{
			System.out.println("Application has some problemij");
		}
		
	// Database validation
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");
		
		Statement stmt=con.createStatement();
		
		String query="select firstname,lastname,email,telephone from oc_customer";
		
		ResultSet rs=stmt.executeQuery(query);
		
		
		boolean status = false;
		
		while(rs.next())
		{
			String firstname=rs.getString("firstname");
			String lastname=rs.getString("lastname");
			String email=rs.getString("email");
			String telephone=rs.getString("telephone");
			
			
			
			if(cust_firstname.equals(firstname)&& cust_lastName.equals(lastname)
					&& cust_email.equals(email) && cust_telephone.equals(telephone))
			{
				System.out.println("Record found in the table || Test Passed");
				status=true;
				break;
			}	
			
		}
		if(status==false)
		{
			System.out.println("Record not found || Test failed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
