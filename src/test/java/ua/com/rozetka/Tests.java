package ua.com.rozetka;

import com.sun.jndi.toolkit.url.Uri;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.rozetka.pages.Basket;
import ua.com.rozetka.pages.HomePage;
import ua.com.rozetka.pages.LogIn;
import java.net.MalformedURLException;

public class Tests {
    WebDriver driver;
    LogIn logIn;
    HomePage homePage;
    Basket basket;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://rozetka.com.ua/");
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void logIn() {
        logIn = new LogIn(driver);
        logIn.closePopUpIfFound();
        logIn.findElementAndClick(logIn.LOGIN);
        logIn.logIn("olya.linchak@mail.ru", "Qwerty123");
        logIn.clickLogInButton();

        Assert.assertTrue(logIn.waitUntilTextToBePresent(logIn.NAME_OF_USER, "Ольга"));
    }


    @Test
    public void checkTheCategoryOpened() throws MalformedURLException {
        homePage = new HomePage(driver);
        homePage.closePopUpIfFound();
        homePage.PointOverElement(homePage.SMARTPHONES);
        homePage.findElementAndClick(homePage.ELECTRONICS);

        Assert.assertEquals("/mobile-phones/c80003/preset=smartfon/", new Uri(driver.getCurrentUrl()).getPath());
    }

    @Test
    public void addTheItemToTheBasket(){
        basket = new Basket(driver);
        basket.PointOverElement(basket.ALCOHOLICBEVER);
        basket.ClickWineCategory();
        basket.findElementAndClick(basket.BUY);
        basket.findElementAndClick(basket.CONTINUI_SHOPPING);
        basket.findElementAndClick(basket.BASKET);
        String str = driver.findElement(By.xpath("//a[contains(@name,'goods-link')][contains(text(),'Вино Echo Falls Chardonnay белое сухое 0.75 л 12.5')]")).getText();

        Assert.assertEquals("Вино Echo Falls Chardonnay белое сухое 0.75 л 12.5% (5010186014536)", str);
    }


}

