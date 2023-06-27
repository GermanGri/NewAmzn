package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends HomePage {

    private static final String SHOPPING_CART_PAGE_XPATH = "//*[@id=sc-active-cart]";

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingCart() {
        return  driver.findElement(By.xpath(SHOPPING_CART_PAGE_XPATH));
    }

}
