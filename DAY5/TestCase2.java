package DAY5;

import java.io.IOException;
import java.time.Duration;
import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("./src/test/resources/DAY5/TestCase2.xlsx");
		Workbook wb = WorkbookFactory.create(file);
	    Sheet sh = wb.getSheet("Sheet1");
	    Row row = sh.getRow(1);
	    String Browser=row.getCell(0).getStringCellValue();
	    String Url=row.getCell(1).getStringCellValue();
	    String Username = row.getCell(2).getStringCellValue();
        String Password = row.getCell(3).getStringCellValue();
        WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(Url);
		Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(Username);
		Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(Password);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(2000);
        
        WebElement text = driver.findElement(By.xpath("//h6[text()='Dashboard']"));	
		if(text.isDisplayed())
			System.out.println("login successfull");
		else
			System.out.println("login unsuccessfull");
		Thread.sleep(3000);
		driver.quit();
	}

}
