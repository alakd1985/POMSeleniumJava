package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    private final By searchFld= By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchBtn= By.cssSelector("button[value='Search']");
    //private final By addtoCartBtn= By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartLink= By.xpath("//a[@title='View cart']");

    private StorePage enterTextSearchFld(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }
    private StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }
    public StorePage search(String txt) {
        enterTextSearchFld(txt).
                clickSearchBtn();

        return this;
    }
    private By getAddToCartBtnElement(String productName){// this is an example of dynamic handling of element
        return By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
    }
    public StorePage clickAddtoCartBtn(String productName){
        By addtoCartBtn= getAddToCartBtnElement(productName);
        driver.findElement(addtoCartBtn).click();
        return this;
    }
    public CartPage clickviewCartLink(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }
}
