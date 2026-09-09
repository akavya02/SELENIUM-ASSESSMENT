package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EaseMyTripD3 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.easemytrip.com/");

        driver.findElement(By.id("oway")).click();

        driver.findElement(By.id("FromSector_show")).click();
        WebElement ele=driver.findElement(By.id("a_FromSector_show"));
        ele.sendKeys("Delhi");
        driver.findElement(By.id("spnNew Delhi")).click();
        driver.findElement(By.id("ptt")).click();
        WebElement ele1=driver.findElement(By.id("a_Editbox13_show"));
        ele1.sendKeys("Bengaluru");
        Thread.sleep(2000);
        driver.findElement(By.id("spnBengaluru")).click();
        driver.findElement(By.id("trd_5_18/09/2026")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='  Traveller & Class ' and @id='ptravlr']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add' and @class='add plus_box1']")).click();
        driver.findElement(By.id("spanEconomy")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='srchBtnSe' and @type='button']")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (url.contains("flight-search/listing")) {
            System.out.println("Flight-results page is displayed");
        } else {
            System.out.println("Flight-results page is not displayed");
        }
        Thread.sleep(3000);
        driver.quit();
        }
}
