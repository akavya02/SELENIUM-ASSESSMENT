package DAY5;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

        FileReader fir = new FileReader("./src/test/resources/DAY5/TestCase3.json");
        JSONParser jsonparser = new JSONParser();
        Object obj = jsonparser.parse(fir);
        JSONObject json = (JSONObject) obj;
        String Browser = json.get("browser").toString();
        String Url = json.get("url").toString();
        String Username = json.get("username").toString();
        String Emailid = json.get("emailid").toString();
        String Password = json.get("password").toString();
        WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(Url);
        driver.findElement(By.id("name")).sendKeys(Username);
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys(Emailid);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(Password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
