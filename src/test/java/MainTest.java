import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import pages.CardDetailsPage;
import pages.CartListPage;
import pages.ShoppingCartPage;
import pages.HomePage;
import pages.ChooseLocationWindow;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    private final static String URL = "https://www.amazon.com/";
    private static final String SEARCH_PHRASE = "cap nike";
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
    @DisplayName("Validate quantity & sum of Amazon")
    void test() {
        driver.get(URL);
        HomePage homePage = new HomePage(driver);
        ChooseLocationWindow chooseLocationWindow = new ChooseLocationWindow(driver);
        homePage.isHomePageValid();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(homePage.getDeliveryIcon()));
        homePage.clickOnDelivery();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        wait.until(ExpectedConditions.elementToBeClickable(chooseLocationWindow.getDeliveryDropdown()));
        chooseLocationWindow.clickOnDropdownDelivery();
        chooseLocationWindow.clickOnPortugal();
        chooseLocationWindow.clickOnDoneBtn();


//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(100));

//      Почему???
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBar()));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        homePage.findGood(SEARCH_PHRASE);

        CartListPage cartListPage = new CartListPage(driver);

        searchCard(cartListPage, 1);

        CardDetailsPage cardDetailsPage = new CardDetailsPage(driver);
        cardDetailsPage.clickToAddToCardButton();
        Assert.assertTrue(cardDetailsPage.isCardWasAddedToBasket());

        cardDetailsPage.clickOnLogo();

        homePage.isHomePageValid();
        homePage.findGood(SEARCH_PHRASE);

        searchCard(cartListPage, 2);
        cardDetailsPage.clickToAddToCardButton();

        assertTrue(cardDetailsPage.isCardWasAddedToBasket());

        cardDetailsPage.clickOnLogo();

        homePage.cartIcon().click();



        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assertions.assertEquals("Amazon.com Shopping Cart", shoppingCartPage.pageVerification());















////        assertEquals("Added to Cart", firstAdd);
//        WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
//        cart.click();
//        String firstSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-active-Cb2b3402d-2bfc-4e56-98af-517f7c3d19bf\"]/div[4]/div/div[2]/ul/div/p/span")).getText();
//        String firstSumWithoutUsd = firstSumUsd.substring(1);
//        double firstSum = Double.parseDouble(firstSumWithoutUsd);
//        String secondSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-active-C0bac48ad-1be3-474a-b895-9a0b8ae65c8a\"]/div[4]/div/div[2]/ul/div/p/span")).getText();
//        String secondSumWithoutUsd = secondSumUsd.substring(1);
//        double secondSum = Double.parseDouble(secondSumWithoutUsd);
//        String capsSumUsd = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span")).getText();
//        String capsSumWithoutUsd = capsSumUsd.substring(1);
//        double capsPrice = Double.parseDouble(secondSumWithoutUsd);
//        assertEquals(capsPrice, (firstSum + secondSum));

//        1. найди мужские кепки
//        1.1 Выбери первую которая есть в наличии
//        2. добавь две кепки  одной марки в корзину
//
//        3. Проверь что общая цена правильная в корзине

//        4. найди женские хуй-знает что например тоже шапки
//        4 Выбери первую которая есть в наличии
//        5. Добавь 3 женские шапки в корзину
//        6. Проверь что цена правильная
//        7. измени количество женский шапок на 3 а мужских на 1
//        8. снова проверь новую общую цену и количесвто
//
//        вот напиши это все на Java+Selenium
//
//        а потом мы вместе подумаем как улучшить твой код
    }
// а почему это в конце?
    private static void searchCard(CartListPage cartListPage, int index) {
        Assert.assertEquals("Amazon.com : cap nike", cartListPage.pageVerification());
        Assert.assertFalse(cartListPage.isCardListIsNotEmpty());
        cartListPage.getCardItem(index).click();
    }

    //TO DO
    private static void fidnPrice(ShoppingCartPage shoppingCartPage, int index){
        Assert.assertEquals("Amazon.com Shopping Cart", shoppingCartPage.pageVerification());

    }



//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }
}