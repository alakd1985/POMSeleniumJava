package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    private final By usernameTextBox= By.cssSelector("#username");
    private final By passwordTextBox= By.cssSelector("#password");
    private final By loginBtn= By.cssSelector("button[value='Log in']");

    public AccountPage enterUsernameTextBox(String txt){
        driver.findElement(usernameTextBox).sendKeys(txt);
        return this;
    }
    public AccountPage enterPasswordTextBox(String txt){
        driver.findElement(passwordTextBox).sendKeys(txt);
        return this;
    }
    public AccountPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new AccountPage(driver);
    }
}
