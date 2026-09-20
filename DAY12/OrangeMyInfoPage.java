package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeMyInfoPage {

    WebDriver driver;

    public OrangeMyInfoPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoLink;


    @FindBy(name = "firstName")
    private WebElement firstNameTextField;


    @FindBy(name = "lastName")
    private WebElement lastNameTextField;


    @FindBy(xpath = "//label[text()='Employee Id']/../..//input")
    private WebElement employeeIdTextField;


    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;


    public void clickMyInfo() throws InterruptedException {

        myInfoLink.click();

        // Wait for My Info page to load
        Thread.sleep(5000);
    }


    public void changeFirstName(String firstName) {

        firstNameTextField.click();

        firstNameTextField.sendKeys(Keys.CONTROL, "a");

        firstNameTextField.sendKeys(Keys.BACK_SPACE);

        firstNameTextField.sendKeys(firstName);

        System.out.println(
                "First Name entered: "
                + firstNameTextField.getAttribute("value"));
    }


    public void changeLastName(String lastName) {

        lastNameTextField.click();

        lastNameTextField.sendKeys(Keys.CONTROL, "a");

        lastNameTextField.sendKeys(Keys.BACK_SPACE);

        lastNameTextField.sendKeys(lastName);

        System.out.println(
                "Last Name entered: "
                + lastNameTextField.getAttribute("value"));
    }


    public void changeEmployeeId(String employeeId) {

        employeeIdTextField.click();

        employeeIdTextField.sendKeys(Keys.CONTROL, "a");

        employeeIdTextField.sendKeys(Keys.BACK_SPACE);

        employeeIdTextField.sendKeys(employeeId);

        System.out.println(
                "Employee ID entered: "
                + employeeIdTextField.getAttribute("value"));
    }


    public void clickSave() throws InterruptedException {

        Thread.sleep(2000);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                saveButton);

        Thread.sleep(3000);

        System.out.println("Save button clicked");
    }


    public String getFirstName()
            throws InterruptedException {

        Thread.sleep(3000);

        return firstNameTextField.getAttribute("value");
    }


    public String getLastName()
            throws InterruptedException {

        Thread.sleep(1000);

        return lastNameTextField.getAttribute("value");
    }


    public String getEmployeeId()
            throws InterruptedException {

        Thread.sleep(1000);

        return employeeIdTextField.getAttribute("value");
    }
}
