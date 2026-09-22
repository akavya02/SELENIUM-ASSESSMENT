package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHRMHOMEPAGE {

    WebDriver driver;
    WebDriverWait wait;

    public OHRMHOMEPAGE(WebDriver driver) {

        this.driver = driver;

        this.wait =new WebDriverWait(driver,Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Buzz']")
    private WebElement buzzLink;

    public void getBuzz() {

        wait.until(ExpectedConditions.elementToBeClickable(buzzLink));

        buzzLink.click();
    }
}
