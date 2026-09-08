package assessmentDAY1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class DemowebshopD2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.id("small-searchterms")).sendKeys("14.1-inch laptop");
		driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//input[@value='Add to cart']"));
		System.out.println("size of the ADD TO CART");
		System.out.println(element.getSize());
		element.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='ico-cart']")).click();
		Thread.sleep(3000);
		WebElement remove=driver.findElement(By.xpath("//input[@type='checkbox' and @name='removefromcart']"));
		if(remove.isSelected())
		{
			System.out.println("remove checkbox is selected");
		}
		else
		{
			System.out.println("remove checkbox is not selected");
		}
		System.out.println("getRect() of remove checkbox");
		System.out.println(remove.getRect().getX());
		System.out.println(remove.getRect().getY());
		System.out.println(remove.getRect().getWidth());
		System.out.println(remove.getRect().getHeight());

		if (driver.findElements(By.xpath("//div[@class='message']")).size() > 0) {
		    System.out.println("Before clicking: Alert message is displayed");
		} else {
		    System.out.println("Before clicking: Alert message is not displayed");
		}
		driver.findElement(By.xpath("//input[@value='Apply coupon']")).click();
		WebElement alertmsg = driver.findElement(By.xpath("//div[@class='message']"));

		if (alertmsg.isDisplayed()) {
		    System.out.println("After clicking Apply Coupon: Alert message is displayed");
		} else {
		    System.out.println("After clicking Apply Coupon: Alert message is not displayed");
		}
		Thread.sleep(3000);
		WebElement laptop = driver.findElement(
			    By.xpath("(//img[@alt='Picture of 14.1-inch Laptop'])[2]")
			);

		File src=laptop.getScreenshotAs(OutputType.FILE);
		File dest=new File("./sshot/laptopImage.png");
		FileHandler.copy(src, dest);
		Thread.sleep(3000);
		driver.quit();
	}

}
