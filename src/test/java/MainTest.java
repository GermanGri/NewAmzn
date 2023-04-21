import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    private final static String URL = "https://www.amazon.com/";
    WebDriver driver;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }
    @Test
    void test() {
        driver.get(URL);

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBar.click();
        searchBar.sendKeys("cap nike");
        searchBar.sendKeys(Keys.RETURN);
        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]"));
        firstItem.click();
        WebElement addBtn = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addBtn.click();
        WebElement addedMessage = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span"));
        String firstAdd = addedMessage.getText();
        assertEquals("Added to Cart", firstAdd);
        WebElement amznLogo = driver.findElement(By.xpath("//*[@id=\"nav-logo\"]"));
        amznLogo.click();
//        ??
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(searchBar));
//        ??
        WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

        search.sendKeys("cap nike");
        search.sendKeys(Keys.RETURN);
        WebElement secondItem = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div[1]"));
        secondItem.click();
//        ??
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
//        ??
//        assertEquals("Added to Cart", firstAdd);
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
        cart.click();
        String firstSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-active-Cb2b3402d-2bfc-4e56-98af-517f7c3d19bf\"]/div[4]/div/div[2]/ul/div/p/span")).getText();
        String firstSumWithoutUsd = firstSumUsd.substring(1);
        double firstSum = Double.parseDouble(firstSumWithoutUsd);
        String secondSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-active-C0bac48ad-1be3-474a-b895-9a0b8ae65c8a\"]/div[4]/div/div[2]/ul/div/p/span")).getText();
        String secondSumWithoutUsd = secondSumUsd.substring(1);
        double secondSum = Double.parseDouble(secondSumWithoutUsd);
        String capsSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span")).getText();
        String capsSumWithoutUsd = capsSumUsd.substring(1);
        double capsPrice = Double.parseDouble(secondSumWithoutUsd);
        assertEquals(capsPrice, (firstSum+secondSum));


    }




//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }

}