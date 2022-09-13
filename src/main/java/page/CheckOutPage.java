package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.cssSelector("#billing_first_name");
    private final By lastName = By.cssSelector("#billing_last_name");
    private final By companyName = By.cssSelector("#billing_company");
    private final By streetAddress = By.cssSelector("#billing_address_1");
    private final By city = By.cssSelector("#billing_city");
    private final By emailAddress = By.cssSelector("#billing_email");
    private final By zipCode = By.cssSelector("#billing_city");

    public CheckOutPage enterFirstName(String txt){
        driver.findElement(firstName).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterLastName(String txt){
        driver.findElement(lastName).sendKeys(txt);
        return this;
    }
    public CheckOutPage entercompanyName(String txt){
        driver.findElement(companyName).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterstreetAddress(String txt){
        driver.findElement(streetAddress).sendKeys(txt);
        return this;
    }
    public CheckOutPage entercity(String txt){
        driver.findElement(city).sendKeys(txt);
        return this;
    }
    public CheckOutPage enteremailAddress(String txt){
        driver.findElement(emailAddress).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterzipCode(String txt){
        driver.findElement(zipCode).sendKeys(txt);
        return this;
    }

}
