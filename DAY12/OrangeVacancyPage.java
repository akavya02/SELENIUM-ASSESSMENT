package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeVacancyPage {

    WebDriver driver;

    // Constructor

    public OrangeVacancyPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Locators

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;


    @FindBy(xpath = "//label[text()='Vacancy Name']/../..//input")
    private WebElement vacancyNameTextField;


    @FindBy(xpath = "//label[text()='Job Title']/../..//div[contains(@class,'oxd-select-text')]")
    private WebElement jobTitleDropdown;


    @FindBy(xpath = "//label[text()='Description']/../..//textarea")
    private WebElement descriptionTextField;


    @FindBy(xpath = "//label[text()='Hiring Manager']/../..//input")
    private WebElement hiringManagerTextField;


    @FindBy(xpath = "//label[text()='Number of Positions']/../..//input")
    private WebElement numberOfPositionsTextField;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;



    // Actions


    public void clickAdd() {

        addButton.click();
    }


    public void enterVacancyName(String vacancyName) {

        vacancyNameTextField.sendKeys(vacancyName);
    }


    public void selectJobTitle(String jobTitle) {

        jobTitleDropdown.click();

        By jobTitleOption = By.xpath("//div[@role='option']//span[text()='"+ jobTitle + "']");

        driver.findElement(jobTitleOption).click();
    }


    public void enterDescription(String description) {

        descriptionTextField.sendKeys(description);
    }


    public void enterHiringManager(String hiringManager) {

        hiringManagerTextField.sendKeys(hiringManager);

        By hiringManagerOption =
                By.xpath("//div[@role='option']//span[contains(text(),'"
                        + hiringManager + "')]");

        driver.findElement(hiringManagerOption).click();
    }


    public void enterNumberOfPositions(String numberOfPositions) {

        numberOfPositionsTextField.sendKeys(numberOfPositions);
    }


    public void clickSave() {

        saveButton.click();
    }
}
