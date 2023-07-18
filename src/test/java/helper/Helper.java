package helper;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.time.Duration;

public class Helper {

    public static final String JS_DOCUMENT_READY = "return document.readyState";
    public static final String JS_COMPLETE = "complete";

    WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementWillBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Validate is page loaded with JavaScript approach
     * @param driver initial WebDriver
     * @return is page loaded
     */
    public boolean isPageLoaded(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(JS_DOCUMENT_READY).toString().equals(JS_COMPLETE);
    }

    public void openPage(String url) {
        try {
            System.out.println("Try to open " + url);
            driver.get(url);
        } catch (Exception e) {
            Assertions.fail("Cannot open a " + url);
        }
    }
}
