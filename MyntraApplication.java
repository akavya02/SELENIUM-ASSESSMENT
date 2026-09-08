package assessmentDAY1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraApplication {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.myntra.com/");
        driver.findElement(By.xpath("//input[contains(@class,'desktop-searchBar')]")).sendKeys("dresses");
        driver.findElement(By.xpath("//a[contains(@class,'desktop-submit')]")).click();
        Thread.sleep(5000);
        WebElement product = driver.findElement(By.xpath("(//li[contains(@class,'product-base')])[1]"));
        new Actions(driver).moveToElement(product).perform();
        driver.findElement(By.xpath("(//li[contains(@class,'product-base')])[1]//span[contains(@class,'product-wishlist')]")).click();
        System.out.println("Product added to wishlist");
        driver.quit();
    }
}
