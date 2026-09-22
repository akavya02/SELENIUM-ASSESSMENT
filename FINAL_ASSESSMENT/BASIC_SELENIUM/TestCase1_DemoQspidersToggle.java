package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQspidersToggle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
		WebElement reff1=driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ')])[1]"));
		WebElement reff2=driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ')])[2]"));
		WebElement reff3=driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ')])[3]"));
		WebElement reff4=driver.findElement(By.xpath("(//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300 ')])[4]"));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('disabled');",reff1);
		reff1.click();
		js.executeScript("arguments[0].removeAttribute('disabled');",reff2);
		reff2.click();
		js.executeScript("arguments[0].removeAttribute('disabled');",reff3);
		reff3.click();
		js.executeScript("arguments[0].removeAttribute('disabled');",reff4);
		reff4.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Thread.sleep(4000);
		String ele=driver.findElement(By.xpath("//p[text()='ORDER PLACED']")).getText();
		
		if(ele.equals("ORDER PLACED"))
		{
			System.out.println("ORDER IS PLACED");
		}
		else
		{
			System.out.println("ORDER NOT PLACED");
		}
		Thread.sleep(4000);
		driver.quit();
	}

}
