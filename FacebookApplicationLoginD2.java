package assessmentDAY1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookApplicationLoginD2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		WebElement firstname = driver.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement surname = driver.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));

		if (firstname.getLocation().getY() == surname.getLocation().getY()) {
		    System.out.println("Both are in same line");
		} else {
		    System.out.println("Both are not in same line");
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
