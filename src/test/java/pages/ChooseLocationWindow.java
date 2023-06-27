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
    //*[@id="GLUXCountryListDropdown"]/span
    //*[@id="a-popover-2"]/div/div[2]/span/span/span


    WebDriver driver;
    public ChooseLocationWindow(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnDropdownDelivery(){driver.findElement(By.xpath(DROPDOWN_LIST_OF_DELIVERY_XPATH)).click();}
    public void clickOnPortugal(){driver.findElement(By.xpath(DROPDOWN_PORTUGAL_XPATH)).click();}
    public void clickOnDoneBtn(){driver.findElement(By.xpath(DONE_BTN_XPATH)).click();}





}
