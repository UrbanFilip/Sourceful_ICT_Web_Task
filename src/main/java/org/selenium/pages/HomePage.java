package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.selenium.base.BasePage;
import org.selenium.pages.components.Cookie;
import org.selenium.pages.components.Header;

public class HomePage extends BasePage {
    private Header header;
    private Cookie cookie;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        cookie = new Cookie(driver);
    }

    public Cookie getCookie() {
        return cookie;
    }

    public Header getHeader() {
        return header;
    }

    public HomePage load() {
        load("/");

        wait.until(driver -> getHeader().getLogo().isDisplayed());
        globalMethods.waitForElementToBeClickable(getCookie().getAcceptCookieButton());
        return this;
    }
}
