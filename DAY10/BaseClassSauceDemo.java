package BASECLASS;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pomutilities.SauceCartPage;
import pomutilities.SauceCheckoutPage;
import pomutilities.SauceLoginPage;
import pomutilities.SauceProductsPage;

public class BaseClassSauceDemo {

    public WebDriver driver;

    public Properties prop;

    public SauceLoginPage loginPage;
    public SauceProductsPage productsPage;
    public SauceCartPage cartPage;
    public SauceCheckoutPage checkoutPage;

    public String firstname;
    public String lastname;
    public String postalcode;


    @BeforeClass
    public void openApplication() throws Exception {

        FileInputStream fis =new FileInputStream("./src/test/resources/DAY10/SauceDemo.properties");

        prop = new Properties();

        prop.load(fis);

        fis.close();

        FileInputStream fis1 =new FileInputStream("./src/test/resources/DAY10/SauceDemo.xlsx");

        Workbook wb = WorkbookFactory.create(fis1);

        Sheet sh = wb.getSheet("Sheet1");

        Row row = sh.getRow(1);

        DataFormatter df = new DataFormatter();

        firstname = df.formatCellValue(
                row.getCell(0)
        );

        lastname = df.formatCellValue(
                row.getCell(1)
        );

        postalcode = df.formatCellValue(
                row.getCell(2)
        );

        wb.close();

        fis1.close();


        // =========================
        // Cross Browser
        // =========================

        String browser = prop.getProperty("browser");


        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Disable Chrome notifications
            options.addArguments("--disable-notifications");


            // Disable Chrome password warning
            HashMap<String, Object> prefs =
                    new HashMap<>();

            prefs.put(
                    "credentials_enable_service",
                    false
            );

            prefs.put(
                    "profile.password_manager_leak_detection",
                    false
            );

            options.setExperimentalOption("prefs",prefs);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));

        Thread.sleep(2000);
        loginPage =new SauceLoginPage(driver);
        productsPage =new SauceProductsPage(driver);
        cartPage =new SauceCartPage(driver);
        checkoutPage =new SauceCheckoutPage(driver);
    }


    @AfterClass
    public void closeBrowser()throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();
    }
}
