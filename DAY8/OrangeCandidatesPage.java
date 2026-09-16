
package DAY8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeCandidatesPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrangeCandidatesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // JOB TITLE
    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement jobTitleDropdown;

    // VACANCY
    @FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement vacancyDropdown;

    // HIRING MANAGER
    @FindBy(xpath = "//label[text()='Hiring Manager']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement hiringManagerDropdown;

    // STATUS
    @FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElement statusDropdown;

    // CANDIDATE NAME
    @FindBy(xpath = "//label[text()='Candidate Name']/following::input[1]")
    private WebElement candidateNameTextField;

    // FROM DATE
    @FindBy(xpath = "//label[text()='Date of Application']/following::input[1]")
    private WebElement fromDateTextField;

    // TO DATE
    @FindBy(xpath = "//label[text()='Date of Application']/following::input[2]")
    private WebElement toDateTextField;

    // SEARCH BUTTON
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    // SELECT JOB TITLE
    public void selectJobTitle(String jobTitle) {
        jobTitleDropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='option']//span[normalize-space()='" + jobTitle + "']")
                )
        );

        option.click();
        System.out.println("Job Title selected: " + jobTitle);
    }

    // SELECT VACANCY
    public void selectVacancy(String vacancy) {
        vacancyDropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='option']//span[normalize-space()='" + vacancy + "']")
                )
        );

        option.click();
        System.out.println("Vacancy selected: " + vacancy);
    }

    // SELECT HIRING MANAGER
    public void selectHiringManager(String hiringManager) {
        hiringManagerDropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='option']//span[normalize-space()='" + hiringManager + "']")
                )
        );

        option.click();
        System.out.println("Hiring Manager selected: " + hiringManager);
    }

    // SELECT STATUS
    public void selectStatus(String status) {
        statusDropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role='option']//span[normalize-space()='" + status + "']")
                )
        );

        option.click();
        System.out.println("Status selected: " + status);
    }

    // ENTER CANDIDATE NAME
    public void enterCandidateName(String candidateName) {
        candidateNameTextField.click();

        // Clear field
        candidateNameTextField.sendKeys(Keys.CONTROL, "a");
        candidateNameTextField.sendKeys(Keys.BACK_SPACE);

        // OrangeHRM autocomplete searches using first name
        String firstName = candidateName.trim().split("\\s+")[0];

        candidateNameTextField.sendKeys(firstName);
        System.out.println("Candidate name entered: " + firstName);

        // WAIT FOR SUGGESTION
        wait.until(driver -> {
            List<WebElement> suggestions = driver.findElements(
                    By.xpath("//div[contains(@class,'oxd-autocomplete-option')]")
            );

            for (WebElement suggestion : suggestions) {
                try {
                    String text = suggestion.getText().trim();

                    System.out.println("Suggestion checking: " + text);

                    if (!text.equalsIgnoreCase("Searching....")
                            && !text.equalsIgnoreCase("Searching...")
                            && !text.equalsIgnoreCase("No Records Found")) {
                        return true;
                    }
                } catch (Exception e) {
                    // DOM refreshed
                }
            }

            return false;
        });

        // FIND FULL CANDIDATE NAME
        By candidateLocator = By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')"
                        + " and normalize-space()='"
                        + candidateName.trim()
                        + "']"
        );

        WebElement candidateSuggestion = wait.until(
                ExpectedConditions.elementToBeClickable(candidateLocator)
        );

        System.out.println("Suggestion found: " + candidateSuggestion.getText());

        // CLICK FULL NAME
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                candidateSuggestion
        );

        System.out.println("Candidate selected: " + candidateName);
    }

    // ENTER FROM DATE
    public void enterFromDate(String fromDate) {
        fromDateTextField.click();
        fromDateTextField.sendKeys(Keys.CONTROL, "a");
        fromDateTextField.sendKeys(Keys.BACK_SPACE);
        fromDateTextField.sendKeys(fromDate);
        fromDateTextField.sendKeys(Keys.ESCAPE);

        System.out.println("From Date entered: " + fromDate);
    }

    // ENTER TO DATE
    public void enterToDate(String toDate) {
        toDateTextField.click();
        toDateTextField.sendKeys(Keys.CONTROL, "a");
        toDateTextField.sendKeys(Keys.BACK_SPACE);
        toDateTextField.sendKeys(toDate);
        toDateTextField.sendKeys(Keys.ESCAPE);

        System.out.println("To Date entered: " + toDate);
    }

    // CLICK SEARCH
    public void clickSearch() {
        try {
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            // Ignore
        }

        wait.until(ExpectedConditions.visibilityOf(searchButton));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                searchButton
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                searchButton
        );

        System.out.println("Search button clicked.");
    }

    // VERIFY CANDIDATE
    public boolean verifyCandidate(String candidateName) {
        try {
            By candidateLocator = By.xpath(
                    "//div[contains(@class,'oxd-table-cell')]"
                            + "//div[normalize-space()='"
                            + candidateName
                            + "']"
            );

            WebElement candidate = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(candidateLocator)
            );

            System.out.println("Candidate is added: " + candidateName);

            return candidate.isDisplayed();

        } catch (Exception e) {
            System.out.println("Candidate is NOT added: " + candidateName);
            return false;
        }
    }
}
