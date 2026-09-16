package DAY8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


    // ADD BUTTON

    @FindBy(xpath = "//button[contains(.,'Add')]")
    private WebElement addButton;


    // FIRST NAME

    @FindBy(name = "firstName")
    private WebElement firstNameTextField;


    // MIDDLE NAME

    @FindBy(name = "middleName")
    private WebElement middleNameTextField;


    // LAST NAME

    @FindBy(name = "lastName")
    private WebElement lastNameTextField;


    // VACANCY

    @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement vacancyDropdown;


    // EMAIL

    @FindBy(xpath = "//label[text()='Email']/following::input[1]")
    private WebElement emailTextField;


    // CONTACT NUMBER

    @FindBy(xpath = "//label[text()='Contact Number']/following::input[1]")
    private WebElement contactNumberTextField;


    // RESUME

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resumeUpload;


    // DATE OF APPLICATION

    @FindBy(xpath = "//label[text()='Date of Application']/following::input[1]")
    private WebElement applicationDateTextField;


    // NOTES

    @FindBy(xpath = "//label[text()='Notes']/following::textarea[1]")
    private WebElement notesTextArea;


    // SAVE BUTTON

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;


    // ACTION METHODS


    // Click Add
    public void clickAdd() {

        addButton.click();
    }


    // Enter First Name
    public void enterFirstName(String firstname) {

        firstNameTextField.sendKeys(firstname);
    }


    // Enter Middle Name
    public void enterMiddleName(String midname) {

        middleNameTextField.sendKeys(midname);
    }


    // Enter Last Name
    public void enterLastName(String lastname) {

        lastNameTextField.sendKeys(lastname);
    }


    // Select Vacancy
    public void selectVacancy(String vacancy) {

        vacancyDropdown.click();

        WebElement option = driver.findElement(
                By.xpath("//div[@role='option']//span[normalize-space()='"
                        + vacancy + "']"));

        option.click();
    }


    // Enter Email
    public void enterEmail(String email) {

        emailTextField.sendKeys(email);
    }


    // Enter Contact Number
    public void enterContactNumber(String contact) {

        contactNumberTextField.sendKeys(contact);
    }


    // Upload Resume
    public void uploadResume(String filePath) {

        resumeUpload.sendKeys(filePath);
    }


    // Enter Date of Application
    public void enterApplicationDate(String date) {

        applicationDateTextField.click();

        // Select existing date
        applicationDateTextField.sendKeys(
                Keys.CONTROL, "a");

        // Delete existing date
        applicationDateTextField.sendKeys(
                Keys.BACK_SPACE);

        // Enter new date
        applicationDateTextField.sendKeys(date);

        // Click Notes to close calendar
        notesTextArea.click();
    }


    // Click Save
    public void clickSave() {

        saveButton.click();
    }
    public void clickCandidates() {

        driver.findElement(
                By.xpath("//a[text()='Candidates']")
        ).click();
    }
}
