package pages;



import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ChooseLocationWindow {
    private static final String DROPDOWN_LIST_OF_DELIVERY_XPATH = "//*[@id='GLUXCountryListDropdown']";
    private static final String DROPDOWN_PORTUGAL_XPATH = "//*[@id='GLUXCountryList_179']";
    private static final String DONE_BTN_XPATH = "//span[@class='a-declarative']";



    WebDriver driver;
    public ChooseLocationWindow(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeliveryDropdown() {
        return driver.findElement(By.xpath(DROPDOWN_LIST_OF_DELIVERY_XPATH));
    }
    public void clickOnDropdownDelivery(){
        getDeliveryDropdown().click();
    };

    public void clickOnPortugal(){driver.findElement(By.xpath(DROPDOWN_PORTUGAL_XPATH)).click();}
    public void clickOnDoneBtn(){driver.findElement(By.xpath(DONE_BTN_XPATH)).click();}





}
