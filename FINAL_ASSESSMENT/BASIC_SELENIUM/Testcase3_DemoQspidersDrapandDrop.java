package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQspidersDrapandDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		WebElement drag1 = driver.findElement(By.id("dragElement1"));
		WebElement drag2 = driver.findElement(By.id("dragElement2"));
		WebElement drag3 = driver.findElement(By.id("dragElement3"));
		WebElement drag4 = driver.findElement(By.id("dragElement4"));
		WebElement drop1 = driver.findElement(By.id("dropZone1"));
		WebElement drop2 = driver.findElement(By.id("dropZone2"));
		
        Actions a = new Actions(driver);
		
		drag2.click();
		drag4.click();
		a.dragAndDrop(drag2,drop1).perform();
		
		drag1.click();
		drag3.click();
		Thread.sleep(1000);
		a.dragAndDrop(drag1,drop2).perform();
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
