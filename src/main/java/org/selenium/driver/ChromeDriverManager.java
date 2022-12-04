package org.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.utils.ConfigReader;

public class ChromeDriverManager {
    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (ConfigReader.HEADLESS.getProperty().equalsIgnoreCase("true")) {
            chromeOptions.addArguments("headless");
        }

        if (ConfigReader.INCOGNITO.getProperty().equalsIgnoreCase("true")) {
            chromeOptions.addArguments("--incognito");
        }

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        return driver;
    }
}
