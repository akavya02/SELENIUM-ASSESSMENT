package DAY8;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase001 {

    public static void main(String[] args) throws Exception {

        // Read properties file
        FileInputStream fis = new FileInputStream("./src/test/resources/DAY6/TestCase01.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        fis.close();

        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get(url);

        // Login
        OrangeLoginPage loginPage = new OrangeLoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Login successful");

        // Click Recruitment
        OrangeHomePage homePage = new OrangeHomePage(driver);
        homePage.clickRecruitment();

        // Recruitment page
        OrangeRecruitmentPage recruitmentPage = new OrangeRecruitmentPage(driver);
        recruitmentPage.clickAdd();

        // Read Excel
        FileInputStream excelFis = new FileInputStream("./src/test/resources/DAY8/TestCase001.xlsx");
        Workbook workbook = WorkbookFactory.create(excelFis);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        DataFormatter formatter = new DataFormatter();

        // Recruitment data
        String firstname = formatter.formatCellValue(row.getCell(0));
        String midname = formatter.formatCellValue(row.getCell(1));
        String lastname = formatter.formatCellValue(row.getCell(2));
        String vacancy = formatter.formatCellValue(row.getCell(3));
        String email = formatter.formatCellValue(row.getCell(4));
        String contact = formatter.formatCellValue(row.getCell(5));
        String resumePath = formatter.formatCellValue(row.getCell(6));
        resumePath = new File(resumePath).getAbsolutePath();
        String dateofapplication = formatter.formatCellValue(row.getCell(7));

        // Candidate search data
        String jobTitle = formatter.formatCellValue(row.getCell(8));
        String hiringManager = formatter.formatCellValue(row.getCell(9));
        String status = formatter.formatCellValue(row.getCell(10));
        String candidateName = formatter.formatCellValue(row.getCell(11));
        String fromDate = formatter.formatCellValue(row.getCell(12));
        String toDate = formatter.formatCellValue(row.getCell(13));

        workbook.close();
        excelFis.close();

        // Enter candidate details
        recruitmentPage.enterFirstName(firstname);
        recruitmentPage.enterMiddleName(midname);
        recruitmentPage.enterLastName(lastname);
        recruitmentPage.selectVacancy(vacancy);
        recruitmentPage.enterEmail(email);
        recruitmentPage.enterContactNumber(contact);
        recruitmentPage.uploadResume(resumePath);
        recruitmentPage.enterApplicationDate(dateofapplication);

        // Save candidate
        recruitmentPage.clickSave();
        System.out.println("Candidate details entered successfully");

        // Click Candidates
        recruitmentPage.clickCandidates();

        // Candidates page
        OrangeCandidatesPage candidatesPage = new OrangeCandidatesPage(driver);

        // Select Job Title
        candidatesPage.selectJobTitle(jobTitle);

        // Select Vacancy
        candidatesPage.selectVacancy(vacancy);

        // Select Hiring Manager
        candidatesPage.selectHiringManager(hiringManager);

        // Select Status
        candidatesPage.selectStatus(status);

        // Enter Candidate Name
        candidatesPage.enterCandidateName(candidateName);

        // Enter From Date
        candidatesPage.enterFromDate(fromDate);

        // Enter To Date
        candidatesPage.enterToDate(toDate);

        // Search
        candidatesPage.clickSearch();

        // Verify Records Found
        boolean result = candidatesPage.verifyCandidate(candidateName);

        if (result) {
            System.out.println("CANDIDATE IS ADDED SUCCESSFULLY");
        } else {
            System.out.println("CANDIDATE IS NOT ADDED");
        }

        // Logout
        homePage.logout();

        // Close browser
        driver.quit();
    }
}


