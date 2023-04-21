package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartListPage extends HomePage {

    private static final String CARD_LIST_XPATH = "//span[@data-component-type='s-search-results']" +
            "//div[@data-component-type='s-search-result']//span[@data-component-type='s-product-image']//a";
    WebDriver driver;

    public CartListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getCardListElements() {
        return driver.findElements(By.xpath(CARD_LIST_XPATH));
    }

    public boolean isCardListIsNotEmpty() {
        return getCardListElements().isEmpty();
    }

    public WebElement getCardItem(int index) {
        return getCardListElements().get(index);
    }
}
