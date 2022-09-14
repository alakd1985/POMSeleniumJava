package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import object.BillingAddress;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import pom.BaseTest;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class OnlineShopping extends BaseTest {
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    AccountPage accountPage = new AccountPage(driver);


    @Test
    public void checkOutWithoutLogIn() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.load();
        Thread.sleep(2000);
        homePage.clickStoreMenuLink();
        StorePage storePage = new StorePage(driver);
        storePage.
                search("Blue").
                clickAddtoCartBtn("Blue Shoes");
        Thread.sleep(5000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(5000);
        js1.executeScript("window.scrollBy(0,350)", "");
        storePage.clickviewCartLink();

//        Assert.assertEquals(driver.findElement(By.cssSelector("//a[normalize-space()='Blue Shoes']")).getText(),
//                "Blue Shoes");

        checkOutPage = new CartPage(driver).
                clickProceedToCheckOutBtn();
        Thread.sleep(5000);
        BillingAddress billingAddress = new BillingAddress().
                setFirstName("alak").
                setLastName("ddd").
                setCompanyName("bbc").
                setAddress("duke st").
                setCity("sunnyvale").
                setZipCode("94086").
                setEmailAddress("abc@gmail.com");
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.setBillingAddress(billingAddress);

    }

    @Test
    public void checkOutWithLogIn() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.clickaccountMenuLink();
        accountPage = new AccountPage(driver);
        accountPage.enterUsernameTextBox("bca").
                enterPasswordTextBox("bca123").
                clickLoginBtn();
        StorePage storepage = homePage.clickStoreMenuLink();
        storepage.search("Blue");
        storepage.clickAddtoCartBtn("Blue Shoes");
        Thread.sleep(5000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(5000);
        js1.executeScript("window.scrollBy(0,350)", "");
        storepage.clickviewCartLink();

//        Assert.assertEquals(driver.findElement(By.cssSelector("//a[normalize-space()='Blue Shoes']")).getText(),
//                "Blue Shoes");

        cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckOutBtn();
        Thread.sleep(5000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterFirstName("alak").
                enterLastName("abd").
                entercompanyName("gdit").
                enterstreetAddress("duke st").
                entercity("sunnyvale").
                enterzipCode("94086").
                enteremailAddress("abc@gmail.com");
    }
}
