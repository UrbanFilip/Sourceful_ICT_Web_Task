package org.selenium.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.base.BasePage;

public class Cookie extends BasePage{
    @FindBy(id = "cookie-law-btn")
    private WebElement acceptCookie;

    @FindBy(id = "cookie-law-bar")
    private WebElement cookieBar;

        public Cookie(WebDriver driver) {
            super(driver);
        }

        public WebElement getAcceptCookieButton() {
            return acceptCookie;
        }
}
