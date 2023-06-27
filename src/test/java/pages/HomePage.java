package pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String TITLE = "Amazon.com. Spend less. Smile more.";
    private static final String SEARCH_BAR_XPATH = "//input[@id='twotabsearchtextbox']";
    private final static String LOGO_XPATH = "//a[@id='nav-logo-sprites']";

    private static final String CART_ICON_XPATH = "//*[@id='nav-cart']";

    private static final String DELIVER_TO_XPATH = "//*[@id='nav-global-location-slot']";


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String pageVerification() {
        return driver.getTitle();
    }

    public void isHomePageValid() {
        Assert.assertEquals(TITLE, pageVerification());
    }

    public void clickOnLogo() {
        driver.findElement(By.xpath(LOGO_XPATH)).click();
    }

    public void clickOnDelivery(){driver.findElement(By.xpath(DELIVER_TO_XPATH)).click();}

    public WebElement getSearchBar() {
        return driver.findElement(By.xpath(SEARCH_BAR_XPATH));
    }

    public void findGood(String goodName) {
        getSearchBar().click();
        getSearchBar().sendKeys(goodName);
        getSearchBar().sendKeys(Keys.RETURN);
    }

    public WebElement cartIcon() {
        return driver.findElement(By.xpath(CART_ICON_XPATH));
    }

}
