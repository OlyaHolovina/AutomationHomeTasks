package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogIn extends PageObjectBase {
    public static final By LOGIN = By.cssSelector("#header_user_menu_parent>a");
    public static final By EMAIL = By.cssSelector(".auth-f-i>input[name='login']");
    public static final By PASSWORD = By.cssSelector(".auth-f-i>input[name='password']");
    public static final By SUBMIT_BUTTON = By.cssSelector(".btn-link-i[type='submit']");
    public static final By NAME_OF_USER = By.cssSelector("#header_user_menu_parent>a");

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserEmail(String userEmail) {
        driver.findElement(EMAIL).sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword) {
        driver.findElement(PASSWORD).sendKeys(userPassword);
    }

    public void clickLogInButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void logIn(String userEmail, String userPassword) {
        this.setUserEmail(userEmail);
        this.setUserPassword(userPassword);
    }


}
