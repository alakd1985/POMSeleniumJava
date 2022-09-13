package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By storeMenuLink= By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
    public StorePage clickStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}
