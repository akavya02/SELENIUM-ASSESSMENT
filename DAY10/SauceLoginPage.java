
package pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    WebDriver driver;

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameTF;

    @FindBy(id = "password")
    private WebElement passwordTF;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterUsername(String username) {
        usernameTF.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTF.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
