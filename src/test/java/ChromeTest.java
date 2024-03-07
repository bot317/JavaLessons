import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;
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
            new WebDriverWait(driver, 10).until(presenceOfElementLocated
                    (By.xpath("//*[contains(@class, 'cookie__cancel')]")));
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

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void test(int num) {
        //Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
        //Не смог найти решение, как пройти третий тест(почему-то открывается новая вкладка вместо переключения форм)
        String [] title1  = { "Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        String [] title2 = {"Номер телефона", "Номер абонента", "Номер счета на 44", "Номер счета на 2073"};
        String [] title3 = {"Сумма", "Сумма", "Сумма", "Сумма"};
        String [] title4 = {"E-mail для отправки чека", "E-mail для отправки чека", "E-mail для отправки чека", "E-mail для отправки чека"};
        String windowHandle = driver.getWindowHandle();
        WebElement selectHeader = driver.findElement
                (By.xpath("//button[@class = 'select__header']/span[@class = 'select__now']"));
        selectHeader.click();
        WebElement selectOption = driver.findElement
                (By.xpath("//p[contains(text(),'" + title1[num] + "')]"));
        selectOption.click();
        driver.switchTo().window(windowHandle);
        WebElement title2InPage = driver.findElement
                (By.xpath("//form[@class ='pay-form opened']/div[1]/input"));
        WebElement title3InPage = driver.findElement
                (By.xpath("//form[@class ='pay-form opened']/div[2]/input"));
        WebElement title4InPage = driver.findElement
                (By.xpath("//form[@class ='pay-form opened']/div[3]/input"));
        assertTrue(selectHeader.getText().contains(title1[num]));
        assertTrue(title2InPage.getAttribute("placeholder").contains(title2[num]));
        assertTrue(title3InPage.getAttribute("placeholder").contains(title3[num]));
        assertTrue(title4InPage.getAttribute("placeholder").contains(title4[num]));
    }


    @Test

    public void testPay() throws InterruptedException {
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
        WebElement iframe = driver.findElement(By.xpath("//*[contains(@class, 'bepaid-iframe')]"));
        driver.switchTo().frame(iframe);
        Thread.sleep(5000); // Знаю что так не рекомендовано делать, но иначе не получалось

        // и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
        WebElement paymentAmountTitle = driver.findElement(By.xpath("//div[@class='header__payment-amount']/span"));
        assertTrue(paymentAmountTitle.getText().contains(money + ".00"));
        WebElement paymentAmountButton = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        assertTrue(paymentAmountButton.getText().contains(money + ".00"));

        // номера телефона
        WebElement phoneNumberTitle = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        assertTrue(phoneNumberTitle.getText().contains(phoneNumber));

        // а также надписей в незаполненных полях для ввода реквизитов карты,
        WebElement title1InPage = driver.findElement
                (By.xpath("//label[@class ='ng-tns-c47-1 ng-star-inserted']"));
        assertTrue(title1InPage.getText().equals("Номер карты"));
        WebElement title2InPage = driver.findElement
                (By.xpath("//label[@class ='ng-tns-c47-4 ng-star-inserted']"));
        assertTrue(title2InPage.getText().equals("Срок действия"));
        WebElement title3InPage = driver.findElement
                (By.xpath("//label[@class ='ng-tns-c47-5 ng-star-inserted']"));
        assertTrue(title3InPage.getText().equals("CVC"));
        WebElement title4InPage = driver.findElement
                (By.xpath("//label[@class ='ng-tns-c47-3 ng-star-inserted']"));
        assertTrue(title4InPage.getText().equals("Имя держателя (как на карте)"));

        // наличие иконок платёжных систем
        WebElement logoMastercard = driver.findElement(By.xpath("//div[@class='cards-brands ng-tns-c47-1']//img[contains(@src, 'mastercard')]"));
        assertTrue(logoMastercard.isEnabled());
        WebElement logoVisa = driver.findElement(By.xpath("//div[@class='cards-brands ng-tns-c47-1']//img[contains(@src, 'visa')]"));
        assertTrue(logoVisa.isEnabled());
        WebElement logoBelkart = driver.findElement(By.xpath("//div[@class='cards-brands ng-tns-c47-1']//img[contains(@src, 'belkart')]"));
        assertTrue(logoBelkart.isEnabled());
        WebElement logoMir = driver.findElement(By.xpath("//div[@class='cards-brands ng-tns-c47-1']//img[contains(@src, 'mir')]"));
        assertTrue(logoMir.isEnabled());
        WebElement logoMaestro = driver.findElement(By.xpath("//div[@class='cards-brands ng-tns-c47-1']//img[contains(@src, 'maestro')]"));
        assertTrue(logoMaestro.isEnabled());
    }
}