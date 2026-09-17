
package pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceProductsPage {

    WebDriver driver;

    public SauceProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsText;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddButton;

    @FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public boolean verifyProductsPage() {
        return productsText.isDisplayed();
    }

    public void addBackpack() {
        backpackAddButton.click();
    }

    public String getCartItemCount() {
        return cartBadge.getText();
    }

    public void clickCart() {
        cartIcon.click();
    }
}
