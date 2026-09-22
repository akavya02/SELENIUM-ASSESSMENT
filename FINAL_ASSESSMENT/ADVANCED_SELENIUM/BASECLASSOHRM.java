package FINALASSESSMENT;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BASECLASSOHRM extends OHRMCOMMONDATA {

    public WebDriver driver = null;

    @BeforeClass
    public void bC() throws IOException {

        // Read browser, URL, username and password
        data();

        // Chrome
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions settings = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection",false);
            settings.setExperimentalOption("prefs",prefs);

            driver = new ChromeDriver(settings);
        }

        // Edge
        else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        // Safari
        else if (browser.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();
        }

        // Maximize
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void bM() {

        OHRMLOGINPAGE login = new OHRMLOGINPAGE(driver);

        // Open application
        driver.get(url);

        // Enter username
        login.getUsernametf(username);

        // Enter password
        login.getPasswordtf(password);

        // Click login
        login.getLoginButton();

        Reporter.log("Login Done", true);
    }

    @AfterMethod
    public void aM() {

        OHRMLOGOUTPAGE logout =new OHRMLOGOUTPAGE(driver);
        logout.logout();
        Reporter.log("Logout Done", true);
    }

    @AfterClass
    public void aC() {

        driver.quit();

        Reporter.log("Browser Closed", true);
    }
}
