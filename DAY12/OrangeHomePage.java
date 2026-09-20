package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {

    WebDriver driver;

    // Constructor

    public OrangeHomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Locators

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentLink;


    // Actions

    public void clickRecruitment() {

        recruitmentLink.click();
    }
}
