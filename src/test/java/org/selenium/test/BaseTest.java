package org.selenium.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.driver.ChromeDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }
    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public void startDriver() {
        setDriver(ChromeDriverManager.createDriver());

        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", "
                + "DRIVER = " + getDriver());
    }

    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("screenshot/" +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");

            takeScreenshot(destFile);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().quit();
    }

    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }
}
