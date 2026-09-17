package DAY10;

import org.testng.annotations.Test;

import BASECLASS.BaseClassSauceDemo;

public class SauceDemoTest extends BaseClassSauceDemo {


    @Test
    public void loginTest()throws InterruptedException {

        // Enter Username

        loginPage.enterUsername(prop.getProperty("username"));
        Thread.sleep(2000);

        // Enter Password

        loginPage.enterPassword(prop.getProperty("password"));
        Thread.sleep(2000);

        // Click Login

        loginPage.clickLogin();
        Thread.sleep(3000);

        // Verify Products Page

        if (productsPage.verifyProductsPage()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is NOT displayed");
        }
        Thread.sleep(2000);
    }



    @Test(dependsOnMethods = "loginTest")
    public void orderPlacementTest()throws InterruptedException {


        // Add Backpack

        productsPage.addBackpack();
        System.out.println("Sauce Labs Backpack added");
        Thread.sleep(2000);

        // Verify Cart Contains 1 Item

        if (productsPage.getCartItemCount().equals("1")) {
            System.out.println("Cart contains 1 item");
        } 
        else 
        {
            System.out.println("Cart does not contain 1 item");
        }
        Thread.sleep(2000);

        // Open Cart

        productsPage.clickCart();
        System.out.println("Cart opened");
        Thread.sleep(2000);

        // Verify Backpack

        if (cartPage.verifyBackpackDisplayed()) 
        {
            System.out.println("Sauce Labs Backpack is displayed");

        } else 
        {
            System.out.println("Sauce Labs Backpack is NOT displayed");
        }
        Thread.sleep(2000);

        // Click Checkout

        cartPage.clickCheckout();
        System.out.println("Checkout page opened");
        Thread.sleep(2000);

        // Enter First Name

        checkoutPage.enterFirstName(firstname);
        Thread.sleep(2000);

        // Enter Last Name

        checkoutPage.enterLastName(lastname);
        Thread.sleep(2000);

        // Enter Postal Code

        checkoutPage.enterPostalCode(postalcode);
        Thread.sleep(2000);


        // Click Continue

        checkoutPage.clickContinue();
        System.out.println("Continue clicked");
        Thread.sleep(3000);
        // Verify Checkout Overview

        if (checkoutPage.verifyCheckoutOverview()) {

            System.out.println("Checkout: Overview page is displayed");
        } else 
        {
            System.out.println("Checkout: Overview page is NOT displayed");
        }
        Thread.sleep(2000);


        // Click Finish

        checkoutPage.clickFinish();
        System.out.println("Finish button clicked");
        Thread.sleep(3000);


        // Verify Thank You Message

        if (checkoutPage.verifyThankYouMessage()) {
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Thank you message is NOT displayed");
        }
        Thread.sleep(3000);
    }
}
