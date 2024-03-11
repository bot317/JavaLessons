import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WildberriesHomePage {
    private WebDriver driver;
    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.wildberries.ru/");
    }
    public int CountProducts (){
        return driver.findElements(By.xpath(
                "//div[@class = 'main-page__content']/article[contains(@class, 'main-page__product product-card j-product-item product-card--hoverable j-content-item')]")).size();
    }
    public void AddProductInBasketByIndex (int indexProduct){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//article[@data-card-index = '" + indexProduct + "']//a[contains(@class, 'product-card__add-basket j-add-to-basket btn-main')]")));
        addButton.click();
    }
    public int FindRealPriceByIndex (int indexProduct){
        WebElement chooseProduct = driver.findElement(By.xpath(
                "//div[@class = 'main-page__content']/article[@data-card-index = '" + indexProduct + "']"));
        chooseProduct.click();
        WebElement priceProduct = driver.findElement(By.xpath(
                "//span[@class='price-block__price']/ins[contains(@class,'price-block__final-price wallet')]"));
        int price = Integer.parseInt(priceProduct.getText().replace("₽", "").replace(" ", ""));
        WebElement returnHomePage = driver.findElement(By.xpath(
                "//div[@class = 'product-page__top-wrap']//button[@class = 'breadcrumbs__back']"));
        returnHomePage.click();
        return price;
    }
    public int FindWBPriceByIndex (int indexProduct){
        WebElement chooseProduct = driver.findElement(By.xpath(
                "//div[@class = 'main-page__content']/article[@data-card-index = '" + indexProduct + "']"));
        chooseProduct.click();
        WebElement priceProduct = driver.findElement(By.xpath(
                "//span[@class='price-block__price']/span[@class='price-block__wallet-price']"));
        int price = Integer.parseInt(priceProduct.getText().replace("₽", "").replace(" ", ""));
        WebElement returnHomePage = driver.findElement(By.xpath(
                "//div[@class = 'product-page__top-wrap']//button[@class = 'breadcrumbs__back']"));
        returnHomePage.click();
        return price;
    }


}
