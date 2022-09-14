package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
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
        driver.get("https://askomdch.com/");
        homePage = new HomePage(driver);
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

    @Test
    public void checkOutWithLogIn() throws InterruptedException {
        driver.get("https://askomdch.com/");
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
