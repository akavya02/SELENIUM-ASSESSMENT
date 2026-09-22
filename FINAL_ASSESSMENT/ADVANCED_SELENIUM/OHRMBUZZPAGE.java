package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHRMBUZZPAGE {

    WebDriver driver;
    WebDriverWait wait;

    public OHRMBUZZPAGE(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // What's on your mind text field
    @FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
    private WebElement postTextField;

    // Post button
    @FindBy(xpath = "//button[normalize-space()='Post']")
    private WebElement postButton;

    // Recent post
    @FindBy(xpath = "//div[contains(@class,'orangehrm-buzz-post-body')]")
    private WebElement recentPost;


    // Enter post
    public void getPostTextField(String value) {

        wait.until(ExpectedConditions.visibilityOf(postTextField));
        postTextField.sendKeys(value);
    }


    // Click Post
    public void getPostButton() {

        wait.until(ExpectedConditions.elementToBeClickable(postButton));
        postButton.click();
    }


    public boolean verifyPost(String value) {

        wait.until(ExpectedConditions.visibilityOf(recentPost));
        return recentPost.getText().contains(value);
    }
}
