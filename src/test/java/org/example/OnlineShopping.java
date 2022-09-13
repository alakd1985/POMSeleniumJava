package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.StorePage;
import pom.BaseTest;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class OnlineShopping extends BaseTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkOutWithoutLogIn() throws InterruptedException {
        driver.get("https://askomdch.com/");
        HomePage homePage = new HomePage(driver);
        StorePage storepage=homePage.clickStoreMenuLink();
        storepage.search("Blue");
        Thread.sleep(5000);
        storepage.clickviewCartLink();


//        Assert.assertEquals(driver.findElement(By.cssSelector("//a[normalize-space()='Blue Shoes']")).getText(),
//                "Blue Shoes");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("alak");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("dutta");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("gdit");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("5335 duke st");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("sunnyvale");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94086");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("leoalak@gmail.com");
        driver.findElement(By.cssSelector("#place_order")).click();
        driver.quit();
    }
    @Test
    public void checkOutWithLogIn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']")).click();
        driver.findElement(By.cssSelector("#reg_username")).sendKeys("abc"+new Random(12));
        driver.findElement(By.cssSelector("#reg_email")).sendKeys("abc@gmail.com"+new Random(12));
        driver.findElement(By.cssSelector("#reg_password")).sendKeys("abc12344"+new Random(12));
        driver.findElement(By.cssSelector("button[value='Register']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement((By.xpath("//a[@title='View cart']"))).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector("//a[normalize-space()='Blue Shoes']")).getText(),
//                "Blue Shoes");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//a[normalize-space()='Proceed to checkout']")).click();
//        driver.findElement(By.cssSelector("#username")).sendKeys("abc");
//        driver.findElement(By.cssSelector("#password")).sendKeys("abc12344");
//        driver.findElement(By.cssSelector("button[value='Login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("alak");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("dutta");
        driver.findElement(By.cssSelector("#billing_company")).sendKeys("gdit");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("5335 duke st");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("sunnyvale");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94086");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("leoalak@gmail.com");
        driver.findElement(By.cssSelector("#place_order")).click();

    }
}
