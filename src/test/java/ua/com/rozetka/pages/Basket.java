package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Basket extends PageObjectBase {
    public static final By ALCOHOLICBEVER = By.xpath("//a[contains(text(),'Алкогольные напитки и продукты')]");
    public static final By WINE = By.xpath("//a[contains(text(),'Сухое')]");
    public static final By BUY = By.xpath("//div[@id='5188850']//button[contains(@title,'Купить')]");
    public static final By CONTINUI_SHOPPING = By.xpath("//a[contains(text(),'Продолжить покупки')]");
    public static final By BASKET = By.xpath("//a[@class='hub-i-link hub-i-cart-link-count sprite-side whitelink']");

    public Basket(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement ClickWineCategory() {
        return this.findElementAndClick(this.WINE);
    }
}
