import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CardDetailsPage;
import pages.CartListPage;
import pages.HomePage;

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
    @DisplayName("Validate quantity & sum of Amazone")
    void test() {
        driver.get(URL);
        HomePage homePage = new HomePage(driver);
        homePage.isHomePageValid();

        homePage.findGood(SEARCH_PHRASE);

        CartListPage cartListPage = new CartListPage(driver);

        searchCard(cartListPage, 0);

        CardDetailsPage cardDetailsPage = new CardDetailsPage(driver);
        cardDetailsPage.clickToAddToCardButton();
        Assert.assertTrue(cardDetailsPage.isCardWasAddedToBasket());

        cardDetailsPage.clickOnLogo();

        homePage.isHomePageValid();
        homePage.findGood(SEARCH_PHRASE);

        searchCard(cartListPage, 1);
        cardDetailsPage.clickToAddToCardButton();
        Assert.assertTrue(cardDetailsPage.isCardWasAddedToBasket());





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
    }

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