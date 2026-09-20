package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {

    WebDriver driver;

    // Constructor

    public OrangeLoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Locators

    @FindBy(name = "username")
    private WebElement usernameTextField;

    @FindBy(name = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    // Actions

    public void enterUsername(String username) {

        usernameTextField.sendKeys(username);
    }


    public void enterPassword(String password) {

        passwordTextField.sendKeys(password);
    }


    public void clickLogin() {

        loginButton.click();
    }
}
