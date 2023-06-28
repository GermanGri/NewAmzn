package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends HomePage {

    private static final String SHOPPING_CART_PAGE_XPATH = "//id[@id=sc-active-cart]";

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

//    public WebElement getShoppingCart() {
//        return  driver.findElement(By.xpath(SHOPPING_CART_PAGE_XPATH));
//    }

    public List<WebElement> getShoppingCart() {
        return driver.findElements(By.xpath(SHOPPING_CART_PAGE_XPATH));
    }


}
