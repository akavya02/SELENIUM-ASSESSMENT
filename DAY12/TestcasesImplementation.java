//TESTCASE1 


package Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BASECLASSUTILITY.BaseClassOrange;
import dataproviderOrange.OrangeHRMData;

import POM.OrangeHomePage;
import POM.OrangeLoginPage;
import POM.OrangeRecruitmentPage;
import POM.OrangeVacancyPage;

public class OrangeHRMTestCase1 extends BaseClassOrange {

    OrangeLoginPage loginPage;
    OrangeHomePage homePage;
    OrangeRecruitmentPage recruitmentPage;
    OrangeVacancyPage vacancyPage;

    @BeforeClass
    public void initializePages() {

        loginPage = new OrangeLoginPage(driver);
        homePage = new OrangeHomePage(driver);
        recruitmentPage =new OrangeRecruitmentPage(driver);
        vacancyPage =new OrangeVacancyPage(driver);
    }

    @Test(
        dataProvider = "vacancyData",dataProviderClass = OrangeHRMData.class
    )
    public void createVacancyTest(
            String vacancyName,
            String jobTitle,
            String description,
            String hiringManager,
            String positions) {

        // Login
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        loginPage.clickLogin();
        // Click Recruitment
        homePage.clickRecruitment();
        // Click Vacancies
        recruitmentPage.clickVacancies();
        // Click Add
        vacancyPage.clickAdd();
        // Enter Vacancy Name
        vacancyPage.enterVacancyName(vacancyName);
        // Select Job Title
        vacancyPage.selectJobTitle(jobTitle);
        // Enter Description
        vacancyPage.enterDescription(description);
        // Enter Hiring Manager
        vacancyPage.enterHiringManager(hiringManager);
        // Enter Number of Positions
        vacancyPage.enterNumberOfPositions(positions);
        // Click Save
        vacancyPage.clickSave();
        // Validation
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Vacancy creation step completed");
    }
}


//TESTCASE2


package Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BASECLASSUTILITY.BaseClassOrange;
import POM.OrangeLoginPage;
import POM.OrangeMyInfoPage;
import POM.OrangeLogoutPage;
import dataproviderOrange.OrangeHRMData;

public class OrangeHRMTestCase2 extends BaseClassOrange {

    OrangeLoginPage loginPage;

    OrangeMyInfoPage myInfoPage;

    OrangeLogoutPage logoutPage;


    @BeforeClass
    public void initializePages() {

        loginPage = new OrangeLoginPage(driver);

        myInfoPage = new OrangeMyInfoPage(driver);

        logoutPage = new OrangeLogoutPage(driver);
    }


    @Test(
            dataProvider = "employeeData",
            dataProviderClass = OrangeHRMData.class
    )
    public void editEmployeeDetailsTest(
            String firstName,
            String lastName,
            String employeeId)
            throws InterruptedException {


        // Login
        loginPage.enterUsername(
                prop.getProperty("username"));

        loginPage.enterPassword(
                prop.getProperty("password"));

        loginPage.clickLogin();


        // Click My Info
        myInfoPage.clickMyInfo();


        // Change First Name
        myInfoPage.changeFirstName(firstName);


        // Change Last Name
        myInfoPage.changeLastName(lastName);


        // Change Employee ID
        myInfoPage.changeEmployeeId(employeeId);


        // Click Save
        myInfoPage.clickSave();


        // Logout
        logoutPage.logout();


        // Login Again
        loginPage.enterUsername(
                prop.getProperty("username"));

        loginPage.enterPassword(
                prop.getProperty("password"));

        loginPage.clickLogin();


        // Click My Info
        myInfoPage.clickMyInfo();


        // Verify First Name
        Assert.assertEquals(
                myInfoPage.getFirstName(),
                firstName,
                "First Name was not updated");


        // Verify Last Name
        Assert.assertEquals(
                myInfoPage.getLastName(),
                lastName,
                "Last Name was not updated");


        // Verify Employee ID
        Assert.assertEquals(
                myInfoPage.getEmployeeId(),
                employeeId,
                "Employee ID was not updated");


        System.out.println(
                "Employee details updated and verified successfully");


        // Logout
        logoutPage.logout();
    }
}
