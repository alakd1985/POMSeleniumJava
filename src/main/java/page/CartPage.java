package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By searchFld= By.cssSelector("//a[normalize-space()='Proceed to checkout']");
}
