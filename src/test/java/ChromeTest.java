import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        try {
//            new WebDriverWait(driver, 10).until(presenceOfElementLocated
//                    (By.xpath("//*[contains(@class, 'cookie__cancel')]")));
//            WebElement cookieCloseButton = driver.findElement(By.xpath("//*[contains(@class, 'cookie__cancel')]"));
//            cookieCloseButton.click();
//        } catch (NoSuchElementException e) {
//            System.out.println("Кнопка хакрытия вкладки cookie не найдена");
//        }
    }

    @AfterEach
    void teardown() {
       //driver.quit();
    }

    @Test
    void testBasket() {
        WildberriesHomePage homePage = new WildberriesHomePage(driver);
        int countProducts = homePage.CountProducts();
        int i = 0;
        Random random = new Random();
        while (i < 5){
            int index = random.nextInt(countProducts);
            int priceReal = homePage.FindRealPriceByIndex(index);
            int priceWB = homePage.FindWBPriceByIndex(index);
            homePage.AddProductInBasketByIndex(index);
            i++;
        }


    }

}