package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQspidersSlidder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		WebElement slider = driver.findElement(By.xpath("//input[@id='slide']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(200, 0).release().perform();
		String ele=driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']")).getText();
		if(ele.contains("Mens Cotton Jacket"))
		{
			System.out.println("Mens Cotton Jacket is identified");
		}
		else
		{
			System.out.println("Mens Cotton Jacket not identified");

		}
		Thread.sleep(4000);
		driver.quit();
	}

}
