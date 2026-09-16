package SauceDemoKeyword;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoimplementation {
	WebDriver driver;
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public void openUrl()
	{
		driver.get("https://www.saucedemo.com/");
	}
	public void Username()
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	public void password()
	{
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	public void login()
	{
		driver.findElement(By.id("login-button")).click();
	}
	public void closeBrowser()
	{
		driver.quit();
	}

}
