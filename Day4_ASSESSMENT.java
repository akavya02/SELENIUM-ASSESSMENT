TESTCASE 1

package assessmentday4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Textfield {

	public static void main(String[] args) throws InterruptedException {

		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://www.facebook.com/reg/?entry_point=login");
		
		//locate text fields
		List<WebElement> tfs = driver.findElements(By.xpath("//input[@inputmode='text']"));
		
		//number of text fields
		System.out.println("Number of text fields: "+tfs.size());
		
		//to get size of each text field
		for(WebElement tf : tfs)
		{
			System.out.println(tf.getSize());
			if(tf.getDomAttribute("type").equals("password"))
				tf.sendKeys("Kavya@123");
		}

		//close the browser
		Thread.sleep(2000);
		driver.quit();
		
	}
}



  TESTCASE 2

package assessmentday4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Zomatoframe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.navigate().to("https://www.zomato.com/bangalore/delivery");
		Thread.sleep(2000);
		
		//clicking on log button
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//switching driver control to the log in page
		WebElement number = driver.findElement(By.id("auth-login-ui"));
		driver.switchTo().frame(number);
		
		//entering the data
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9878654534");
		
		driver.findElement(By.xpath("//i[@class='sc-rbbb40-1 cLEXmC sc-re4bd0-1 bKymEa']")).click();
		Thread.sleep(3000);
		
		//switching driver control back to the main page
		driver.switchTo().defaultContent();
		
		//verifying the driver control
		WebElement txt=driver.findElement(By.xpath("//div[text()='Delivery']"));
		System.out.println(txt.getText());
		if(txt.isDisplayed())
		{
			System.out.println("page contains --delivery-- text");
		}
		else
		{
			System.out.println("page doesnt contain ==delivery");
		}
		Thread.sleep(3000);
		
		driver.quit();

	}

}

TESTCASE 3

package assessmentday4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//naviagte to application
		driver.get("https://www.bigbasket.com/pb/boss/");
		
		//locate search box and type apples
		driver.findElement(By.xpath("(//input[@type='text'])[last()]")).sendKeys("apples");
		Thread.sleep(1000);
		
		//store all the suggestions
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='overscroll-contain']/li"));
		
		//iterate each suggestion until it contains appli shimla - small and click add
		for(WebElement li : list)
		{
			String text = li.getText();
			
			//search for specific product
			if(text.contains("Apple Shimla - Small"))
			{
				li.findElement(By.xpath(".//button[text()='Add']")).click();
				WebElement text1 = driver.findElement(By.xpath("//p[text()='Item has been added to your basket successfully']"));
				
				//verify
				if(text1.isDisplayed())
				{
					System.out.println("product is added to cart sucessfully");
					break;
				}
				else
				{
					System.out.println("product not added to cart");
					break;
				}
			}
		}
		
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
	}

}


}
