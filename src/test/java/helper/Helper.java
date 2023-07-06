package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
