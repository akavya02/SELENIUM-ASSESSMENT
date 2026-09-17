package pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceCartPage {

    WebDriver driver;

    public SauceCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpackName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public boolean verifyBackpackDisplayed() {
        return backpackName.isDisplayed();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
