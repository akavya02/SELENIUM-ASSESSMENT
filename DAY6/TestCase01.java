package DAY6;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase01 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		FileInputStream file=new FileInputStream("./src/test/resources/DAY6/TestCase01.properties");
		Properties p=new Properties();
		p.load(file);
	    String Browser1=p.getProperty("browser");
	    String Url1=p.getProperty("url");
	    String Username1 = p.getProperty("username");
        String Password1 = p.getProperty("password");
        WebDriver driver=null;
        if(Browser1.equals("chrome")) {
            driver = new ChromeDriver(settings);
        }
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(Url1);
		Thread.sleep(2000);
		//to enter username on login page
        driver.findElement(By.name("username")).sendKeys(Username1);
		Thread.sleep(2000);
		//to enter password on login page
        driver.findElement(By.name("password")).sendKeys(Password1);
		Thread.sleep(2000);
		//to click on login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		//to click onPIM Link
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(5000);
		//to click on Add button
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(4000);
		
		FileInputStream file1=new FileInputStream("./src/test/resources/DAY6/TestCase01.xlsx");
		Workbook wb=WorkbookFactory.create(file1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(1);
		String Browser2=row.getCell(0).getStringCellValue();
		String Url2=row.getCell(1).getStringCellValue();
		String firstname=row.getCell(2).getStringCellValue();
		String middlename=row.getCell(3).getStringCellValue();
		String lastname=row.getCell(4).getStringCellValue();
		String employeeid = String.valueOf((long) row.getCell(5).getNumericCellValue());
		String username=row.getCell(6).getStringCellValue();
		String password=row.getCell(7).getStringCellValue();
		String ConfirmPassword=row.getCell(8).getStringCellValue();
		String AdminUsername = row.getCell(9).getStringCellValue();
		String UserRole = row.getCell(10).getStringCellValue();
		String EmployeeName = row.getCell(11).getStringCellValue();
		String Status = row.getCell(12).getStringCellValue();
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //to enter firstname
        driver.findElement(By.name("firstName")).sendKeys(firstname);
		Thread.sleep(2000);
		//to enter middlename
        driver.findElement(By.name("middleName")).sendKeys(middlename);
		Thread.sleep(2000);
		//to enter lastname
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		Thread.sleep(2000);
		//to remove existing empId and type new empId
		WebElement empId = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		empId.click();
		empId.sendKeys(Keys.CONTROL, "a");
		empId.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		empId.sendKeys(employeeid);
		//to click on create login details
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		Thread.sleep(5000);
		//to enter username
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div[1]//input")).sendKeys(username);
		Thread.sleep(5000);
		//to enter password
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password);
		Thread.sleep(5000);
		//to enter password and confirm password
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(ConfirmPassword);
		Thread.sleep(5000);
		//to click on save/submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//to click on admin link
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(5000);
		// Admin Username
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input")).sendKeys(AdminUsername);
		Thread.sleep(2000);
		// User Role
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='" + UserRole + "']")).click();
		Thread.sleep(2000);
		// Employee Name
		WebElement empName = driver.findElement(By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input"));
		empName.sendKeys(EmployeeName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'oxd-autocomplete-option')]//span[contains(normalize-space(),'Kavya')]")).click();
		Thread.sleep(2000);
		// Status
		driver.findElement(By.xpath("//label[text()='Status']/parent::div/following-sibling::div//i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role='option' and normalize-space()='" + Status + "']")).click();
		Thread.sleep(2000);
		// Search
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

		Thread.sleep(3000);
		//to verify
		if(driver.findElements(By.xpath("//div[@role='row']//div[normalize-space()='" + AdminUsername + "']")).size() > 0)
		{
		    System.out.println("Employee record found");
		}
		else
		{
		    System.out.println("Employee record not found");
		}
		//to logout
		driver.findElement(By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        driver.quit();
		
	}

}
