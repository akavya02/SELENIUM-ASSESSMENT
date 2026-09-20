package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeRecruitmentPage {

    WebDriver driver;

    // Constructor

    public OrangeRecruitmentPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Locators

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacanciesLink;


    // Actions

    public void clickVacancies() {

        vacanciesLink.click();
    }
}
