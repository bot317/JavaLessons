import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WildberriesHomePage {
    private WebDriver driver;
    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public int CountProducts (){
        return driver.findElements(By.xpath(
                "//div[@class = 'main-page__content'/article[@class = 'main-page__product product-card j-product-item product-card--hoverable j-content-item']")).size();
    }
    public void AddProductInBasketByIndex (int indexProduct){
        WebElement addButton = driver.findElement(By.xpath(
                "//div[@class = 'main-page__content'/article[@data-card-index = '" + indexProduct + "'//a[@class = 'product-card__add-basket j-add-to-basket btn-main'"));
        addButton.click();
    }
    public float FindRealPriceByIndex (int indexProduct){
        String homeWindow = driver.getWindowHandle();
        WebElement chooseProduct = driver.findElement(By.xpath(
                "//div[@class = 'main-page__content'/article[@data-card-index = '" + indexProduct + "'"));
        chooseProduct.click();
        WebElement priceProduct = driver.findElement(By.xpath(
                "//div[@class = 'product-page__grid'/span [@class='price-block__price']/ins [@class='price-block__final-price wallet']"));
        return Float.parseFloat(priceProduct.getText());
    }
    public float FindWBPriceByIndex (int indexProduct){
        String homeWindow = driver.getWindowHandle();
        WebElement chooseProduct = driver.findElement(By.xpath(
                "//div[@class = 'main-page__content'/article[@data-card-index = '" + indexProduct + "'"));
        chooseProduct.click();
        WebElement priceProduct = driver.findElement(By.xpath(
                "//div[@class = 'product-page__grid'/span [@class='price-block__price']/span [@class='price-block__wallet-price']"));
        return Float.parseFloat(priceProduct.getText());
    }


}
