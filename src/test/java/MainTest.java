import helper.Helper;
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
import java.util.List;

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
    void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
        HomePage homePage = new HomePage(driver);
        ChooseLocationWindow chooseLocationWindow = new ChooseLocationWindow(driver);
        homePage.isHomePageValid();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(homePage.getDeliveryIcon()));
        homePage.clickOnDelivery();
        Thread.sleep(2000);


        Helper helper = new Helper(driver);
        helper.waitForElementWillBeClickable(chooseLocationWindow.getDeliveryDropdown(), 10);
//        wait.until(ExpectedConditions.elementToBeClickable(chooseLocationWindow.getDeliveryDropdown()));
        chooseLocationWindow.clickOnDropdownDelivery();
        chooseLocationWindow.clickOnCountry("Portugal");
        chooseLocationWindow.clickOnDoneBtn();

//        ?? ВОПРОС
//        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchBar()));
//        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchBar()));
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Thread.sleep(2000);
        homePage.findGood(SEARCH_PHRASE);

        CartListPage cartListPage = new CartListPage(driver);

        searchCard(cartListPage, 2);

        CardDetailsPage cardDetailsPage = new CardDetailsPage(driver);
        cardDetailsPage.clickToAddToCardButton();
        Assert.assertTrue(cardDetailsPage.isCardWasAddedToBasket());

        cardDetailsPage.clickOnLogo();
        homePage.isHomePageValid();
        homePage.findGood(SEARCH_PHRASE);

        searchCard(cartListPage, 3);
        cardDetailsPage.clickToAddToCardButton();

        assertTrue(cardDetailsPage.isCardWasAddedToBasket());

        cardDetailsPage.clickOnLogo();

        homePage.cartIcon().click();


        // check page
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assertions.assertEquals("Amazon.com Shopping Cart", shoppingCartPage.pageVerification());


        // Найти все элементы <div> с классом "sc-item-price-block-badge"
//        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='sc-item-price-block-badge']"));

        List<WebElement> priceElements = shoppingCartPage.getPricesElements();

        String firstPrice1 = null;
        String secondPrice2 = null;

        // Проверить, что в списке есть два элемента
        if (priceElements.size() >= 2)  {
            // Получить текст с ценой для каждого элемента
            WebElement firstPriceElement = priceElements.get(0);
            WebElement secondPriceElement = priceElements.get(1);

            String firstPrice = firstPriceElement.getText();
            String secondPrice = secondPriceElement.getText();

            firstPrice1 = firstPrice;
            secondPrice2 = secondPrice;

            System.out.println("Первая цена: " + firstPrice);
            System.out.println("Вторая цена: " + secondPrice);
        } else {
            System.out.println("Недостаточно элементов с ценой");
        }

        String trimmedFirstPrice = firstPrice1.substring(1);
        String trimmedSecondPrice = secondPrice2.substring(1);

        double firstPriceNumber = Double.parseDouble(trimmedFirstPrice);
        double secondPriceNumber = Double.parseDouble(trimmedSecondPrice);

        double summedNumbers = firstPriceNumber + secondPriceNumber;

        System.out.println("Сумма факт:" + summedNumbers);
        WebElement subtotalFromPageString = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']"));
//        почему не могу тут же обрезать знак доллара?
        String stringSubtotalFromPageNumber = subtotalFromPageString.getText();
//        почему два символа??
        String trimmedStringSubtotalFromPageNumber = stringSubtotalFromPageNumber.substring(2);

        System.out.println("Сумма на сайте:" + trimmedStringSubtotalFromPageNumber);
        double subtotalFromPageNumber = Double.parseDouble(trimmedStringSubtotalFromPageNumber);
//        вопрос - если более 30сек тогда Connection reset

        if(summedNumbers == subtotalFromPageNumber){
            System.out.println("Итоговая сумма верна!");
        } else {
            System.out.println("Сумма не верна, ОШИБКА!");
        }



//        1. найди мужские кепки
//        1.1 Выбери первую которая есть в наличии
//        2. добавь две кепки  одной марки в корзину
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

    @AfterEach
    void teardown() {
        driver.quit();
    }
}