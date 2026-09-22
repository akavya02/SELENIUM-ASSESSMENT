package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppersStack {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'MuiPape')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Check Delivery")).sendKeys("583104");
		Thread.sleep(2000);
		
		WebElement ref = driver.findElement(By.id("Check"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(ref));
	    ref.click();
			
		String text = driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
		Thread.sleep(2000);
		System.out.println(text);
		driver.quit();

	}

}
