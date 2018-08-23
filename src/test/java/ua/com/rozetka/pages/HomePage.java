package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObjectBase {
    public static final By SMARTPHONES = By.xpath("//a[contains(text(),'Смартфоны, ТВ и электроника')]");
    public static final By ELECTRONICS = By.xpath("//a[@class='f-menu-sub-l-i-link novisited'][contains(text(),' Смартфоны ')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
