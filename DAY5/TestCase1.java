package DAY5;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream file= new FileInputStream("./src/test/resources/DAY5/TestCase1.properties");
		Properties p = new Properties();
		p.load(file);
		String Browser=p.getProperty("browser");
		String Url=p.getProperty("url");
		String Email=p.getProperty("email");
		String Password=p.getProperty("password");
		
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Url);
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys(Email);
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}


		
