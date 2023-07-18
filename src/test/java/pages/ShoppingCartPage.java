package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends HomePage {

    private static final String ITEM_PRICES_XPATH = "//div[@class='sc-item-price-block-badge']";
    public static final String SUBTOTAL_PRICE = "//span[@id='sc-subtotal-amount-activecart']";


    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public List<WebElement> getPricesElements() {
        return driver.findElements(By.xpath(ITEM_PRICES_XPATH));
    }

    public String getClearPrizeWithoutCurrency(String curency, String xpath) {
        return driver.findElement(By.xpath(xpath)).getText().trim().replace(curency, "");
    }

    public Double getClearPrizeWithoutCurrencyInDouble(String curency, String xpath) {
        return Double.parseDouble(driver.findElement(By.xpath(xpath)).getText().trim().replace(curency, ""));
    }



}
