package assessmentDAY1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplyingMethodsonFaceBookD2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		
		System.out.println("location of create new account button:");
		WebElement ele=driver.findElement(By.xpath("//span[text()='Create new account']"));
		System.out.println(ele.getLocation());
		System.out.println();

		WebElement e = driver.findElement(By.xpath("//input[@name='email']"));
		
		System.out.println("Before:");
		System.out.println(e.getDomAttribute("value"));
		System.out.println(e.getDomProperty("value"));

		e.sendKeys("kavya@gmail.com");
		System.out.println();
		
		System.out.println("After:");
		System.out.println(e.getDomAttribute("value"));
		System.out.println(e.getDomProperty("value"));
		
		Thread.sleep(3000);
		ele.click();
		System.out.println();

		System.out.println("size of signup/submit ");
		WebElement element=driver.findElement(By.xpath("//span[text()='Submit' and @class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft']"));
		System.out.println(element.getSize());
		System.out.println();

		Thread.sleep(3000);
		
		System.out.println("css properties of sign up/submit button:");
		System.out.println(element.getCssValue("font-family"));
		System.out.println(element.getCssValue("font-size"));
		System.out.println(element.getCssValue("font-weight"));
		
		Thread.sleep(3000);
		driver.quit();

	}

}
