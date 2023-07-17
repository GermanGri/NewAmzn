package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends HomePage {

    private static final String ITEM_PRICES_XPATH = "//div[@class='sc-item-price-block-badge']";


    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }




    public List<WebElement> getPricesElements() {
        return driver.findElements(By.xpath(ITEM_PRICES_XPATH));
    }


}
