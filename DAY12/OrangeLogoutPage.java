package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLogoutPage {

    WebDriver driver;

    public OrangeLogoutPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutLink;


    public void clickUserDropdown() {

        userDropdown.click();
    }


    public void clickLogout() {

        logoutLink.click();
    }


    public void logout() {

        clickUserDropdown();

        clickLogout();
    }
}
