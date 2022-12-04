package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.base.BasePage;
import org.selenium.pages.components.Header;

public class ContactPage extends BasePage {
    private Header header;

    @FindBy(name = "your-name")
    private WebElement nameInput;

    @FindBy(name = "your-email")
    private WebElement emailInput;

    @FindBy(name = "your-subject")
    private WebElement subjectInput;

    @FindBy(name = "your-message")
    private WebElement messageInput;

    @FindBy(css = ".wpcf7-submit")
    private WebElement submitButton;

    @FindBy(css = ".wpcf7-response-output")
    private WebElement responseText;

    @FindBy(css = ".wp-image-845")
    private WebElement image;


    public Header getHeader() {
        return header;
    }

    public ContactPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    private ContactPage fillName(String name) {
        globalMethods.fillInput(nameInput, name);

        return this;
    }

    private ContactPage fillEmail(String email) {
        globalMethods.fillInput(emailInput, email);

        return this;
    }

    private ContactPage fillSubject(String subject) {
        globalMethods.fillInput(subjectInput, subject);

        return this;
    }

    private ContactPage fillMessageInput(String message) {
        globalMethods.fillInput(messageInput, message);

        return this;
    }

    public ContactPage sendForm() {
        globalMethods.clickOn(submitButton);

        return this;
    }

    public String getResponse() {
        return globalMethods.getText(responseText);
    }

    public ContactPage fillForm(String name, String email, String subject, String message) {
        wait.until(driver -> image.isDisplayed());
        fillName(name)
                .fillEmail(email)
                .fillSubject(subject)
                .fillMessageInput(message);

        return this;
    }
}
