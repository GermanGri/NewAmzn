package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardDetailsPage extends HomePage {

    private final static String ADD_TO_CARD_XPATH = "//input[@id='add-to-cart-button']";
    private final static String ADDED_TO_CARD_LABEL_XPATH = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']//span";
    WebDriver driver;

    public CardDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddToCardButton() {
        driver.findElement(By.xpath(ADD_TO_CARD_XPATH)).click();
    }

    public boolean isCardWasAddedToBasket() {
        return driver.findElement(By.xpath(ADDED_TO_CARD_LABEL_XPATH)).getText().equals("Added to Cart");
    }
}
