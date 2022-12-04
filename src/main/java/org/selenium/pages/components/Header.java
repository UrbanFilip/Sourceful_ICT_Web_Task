package org.selenium.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;
import org.selenium.pages.ContactPage;

public class Header extends BasePage {
    @FindBy(id = "main-logo")
    private WebElement logo;

    @FindBy(xpath = "//ul[starts-with(@id, 'menu-menu')]/li[6]")
    private WebElement contactLink;

    @FindBy(css = ".lang-item-pl")
    private WebElement polishButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogo() {
        return logo;
    }

    public ContactPage clickOnContactLinkFromMenu() {
        globalMethods.clickOn(contactLink);

        wait.until(ExpectedConditions.urlContains("contact"));

        return new ContactPage(driver);
    }

    public Header clickOnPolishButton() {
        globalMethods.clickOn(polishButton);
        wait.until(ExpectedConditions.urlContains("pl"));

        return this;
    }
}
