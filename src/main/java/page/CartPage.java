package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By proceedToCheckOutBtn= By.xpath("//a[normalize-space()='Proceed to checkout']");

    public CheckOutPage clickProceedToCheckOutBtn(){
        driver.findElement(proceedToCheckOutBtn).click();
        return new CheckOutPage(driver);
    }
}
