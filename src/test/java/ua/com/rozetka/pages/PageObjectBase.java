package ua.com.rozetka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class PageObjectBase {
    WebDriver driver;
    By CLOSE_POP_UP_BUTTON = By.cssSelector(".exponea-close>span");

    public void closePopUpIfFound() {
        WebElement element = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(CLOSE_POP_UP_BUTTON));

        if (element != null) {
            element.click();
        }
    }

    public boolean waitUntilTextToBePresent(By locator, String text) {
        Boolean element = getWebDriverWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        return element;
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 4);
    }

    public WebElement findElementAndClick(By locator) {
        WebElement element = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        return element;
    }

    public void PointOverElement(By locator){
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).perform();
    }

}
