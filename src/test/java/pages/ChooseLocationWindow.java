package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseLocationWindow {
    private static final String DROPDOWN_LIST_OF_DELIVERY_XPATH = "//span[@id='GLUXCountryListDropdown']";
    private static final String COUNTRY_DROPDOWN_LIST = "//div[@class='a-popover-inner a-lgtbox-vertical-scroll']//ul[@class='a-nostyle a-list-link']/li/a[text()='%s']";

    private static final String DONE_BTN_XPATH = "//span[@class='a-declarative']";


    WebDriver driver;

    public ChooseLocationWindow(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeliveryDropdown() {
        return driver.findElement(By.xpath(DROPDOWN_LIST_OF_DELIVERY_XPATH));
    }

    public void clickOnDropdownDelivery() throws InterruptedException {
        getDeliveryDropdown().click();
        Thread.sleep(2000);
    }

    public void clickOnCountry(String countryName) {
        driver.findElement(By.xpath(String.format(COUNTRY_DROPDOWN_LIST, countryName))).click();
    }

    public void clickOnDoneBtn() {
        driver.findElement(By.xpath(DONE_BTN_XPATH)).click();
    }


}
