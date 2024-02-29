import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ChromeTest {

    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        try {

            new WebDriverWait(driver, 10).until(presenceOfElementLocated(By.xpath("//*[contains(@class, 'cookie__cancel')]")));
            WebElement cookieCloseButton = driver.findElement(By.xpath("//*[contains(@class, 'cookie__cancel')]"));
            cookieCloseButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка хакрытия вкладки cookie не найдена");
        }

    }

    @AfterEach
    void teardown() {
       driver.quit();
    }

    @Test
    public void testTitle() {
        // Проверить название указанного блока
        WebElement title = driver.findElement(By.xpath("//*[contains(@class, 'pay__wrapper')]"));
        assertTrue(title.getText().replace("\n", " ").contains("Онлайн пополнение без комиссии"));
    }

    @Test
    public void testLogo() {
        // Проверить наличие логотипов платёжных систем
        List<WebElement> paymentLogos = driver.findElements(By.xpath("//*[contains(@class, 'pay__partners')]"));
        for (WebElement logo : paymentLogos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void testLink() {

        // Проверяем работу ссылки "Подробнее о сервисе"
        WebElement detailsLink = driver.findElement(By.xpath("//section[@class='pay']//a[text()='Подробнее о сервисе']"));
        detailsLink.click();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void testPay() {
        // Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить»
        String phoneNumber = "297777777";
        String money = "200";
        driver.findElement(By.xpath("//div[@class='pay__forms']//input[contains(@class, 'phone')]"))
                .sendKeys(phoneNumber);
        driver.findElement(By.xpath("//div[@class='pay__forms']//input[contains(@class, 'total_rub')]"))
                .sendKeys(money);
        driver.findElement(By.xpath("//div[@class='pay__forms']//input[contains(@class, 'email')]"))
                .sendKeys("mail@yandex.ru");

        WebElement continueButton = driver.findElement(By.xpath("//div[@class='pay__forms']//button[contains(@class, 'button__default')]"));
        continueButton.click();
        // и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
        WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'bepaid-iframe')]"));
        driver.switchTo().frame(iframe);
        WebElement titlePay = driver.findElement(By.xpath("//div[@class = 'header__payment-amount']/span"));
        System.out.println(titlePay.getText());
        assertTrue(titlePay.getText().contains("200.00 BYN"));
        // номера телефона,
        // а также надписей в незаполненных полях для ввода реквизитов карты,
        // наличие иконок платёжных систем.

        WebElement nextElement = driver.findElement(By.xpath("//*[contains(@class, 'app-wrapper__content')]"));
        assertTrue(nextElement.isEnabled());

    }

}