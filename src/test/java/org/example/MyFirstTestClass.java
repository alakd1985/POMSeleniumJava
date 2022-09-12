package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class MyFirstTestClass
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void myFirstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Thread.sleep(3000);
       

//        Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Search results: “blue”')]")).
//                getText(),"Search results: “blue”");
        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
        driver.findElement((By.cssSelector("a[title='View cart']"))).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("//a[normalize-space()='Blue Shoes']")).getText(),
                "Blue Shoes");
    }
}
