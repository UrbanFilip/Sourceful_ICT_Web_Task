package org.selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class GlobalMethods {
    private WebDriver driver;
    private WebDriverWait wait;

    public GlobalMethods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOn(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillInput(WebElement element, String text) {
        waitUntilVisible(element).sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitUntilVisible(element).getText();
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(driver -> element.isDisplayed());

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(ElementClickInterceptedException.class);
        fluentWait.until(driver -> {
                    element.click();
                    return true;
                }
        );
    }
}
