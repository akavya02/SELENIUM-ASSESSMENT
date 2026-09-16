
package DAY8;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHomePage {

    WebDriver driver;
    WebDriverWait wait;

    // CONSTRUCTOR

    public OrangeHomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    // RECRUITMENT

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentLink;

    // USER DROPDOWN

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;

    // LOGOUT

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;

    // CLICK RECRUITMENT

    public void clickRecruitment() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        recruitmentLink
                )
        );

        recruitmentLink.click();

        System.out.println(
                "Recruitment clicked."
        );
    }

    
    // LOGOUT

    public void logout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        userDropdown
                )
        );

        userDropdown.click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        logoutLink
                )
        );

        logoutLink.click();

        System.out.println(
                "Logout successful."
        );
    }
}
