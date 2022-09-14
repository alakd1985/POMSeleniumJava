package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
    private final By accountMenuLink = By.cssSelector("li[id='menu-item-1237'] a[class='menu-link']");

    //    public HomePage load(){
//        driver.get("/");
//        return this;
//    }
    public void load() {
        driver.get("https://askomdch.com/");
    }

    public StorePage clickStoreMenuLink() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

    public AccountPage clickaccountMenuLink() {
        driver.findElement(accountMenuLink).click();
        return new AccountPage(driver);
    }

}
