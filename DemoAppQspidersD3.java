package assessments;

import java.time.Duration;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAppQspidersD3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
        driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='10']")).click();
        Thread.sleep(5000);
        WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Select A Date']"));
        String actualdate=ele.getAttribute("value");
        System.out.println(actualdate);
        if(actualdate.equals("10/10/2026"))
        {
        	System.out.println("Date is displayed correctly\"");
        }
        else
        {
        	System.out.println("Date is not displayed correctly\"");
        }
        driver.quit();
    }
}

