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

//    public boolean isCartAvailableForOrder() {
//        WebElement quantity, addToBasketButton;
//        return quantity.isDisplayed() && addToBasketButton.isDisplayed() && addToBasketButton.isEnabled();
//        // check: if we had a quantity and 'add to card' button presented and enable -> true
//        // if not - false
//    }

//    public void selectAvailableCart() {
//        for (int i=0; i<getCardListElements().size(); i++) {
//            getCardListElements().get(i).click();
//            if (isCartAvailableForOrder()) {
//                // select quantity
//                // cartListPage.getCardItem(index).click();
//                break;
//            } else {
//
//            }
//        }
//    }

    public WebElement getCardItem(int index) {
        return getCardListElements().get(index);
    }
}
