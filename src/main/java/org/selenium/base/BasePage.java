package org.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utils.GlobalMethods;
import org.selenium.utils.ConfigReader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected GlobalMethods globalMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.WAIT_TIMEOUT.getProperty())));
        PageFactory.initElements(driver, this);
        globalMethods = new GlobalMethods(driver, wait);
    }

    public void load(String endpoint) {
        driver.get(ConfigReader.BASE_URL.getProperty() + endpoint);
    }
}
