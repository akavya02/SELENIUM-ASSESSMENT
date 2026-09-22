package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHRMLOGOUTPAGE {

    WebDriver driver;
    WebDriverWait wait;

    public OHRMLOGOUTPAGE(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement profile;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(profile));

        profile.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        logoutButton.click();
    }
}
