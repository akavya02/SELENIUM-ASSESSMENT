package assessmentDAY1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraApplication {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.get("https://www.myntra.com/");
	        driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("dresses");
	        driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
	        driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']"));
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']")).click();
	        String text=driver.getTitle();
	        if(text.equals("Myntra")) {
	        	System.out.println("Product added to wishlist");
	        }
	        Thread.sleep(2000);
	        driver.quit();
		
	}

}



