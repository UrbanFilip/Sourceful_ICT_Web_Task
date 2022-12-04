package org.selenium.test;

import org.selenium.pages.ContactPage;
import org.selenium.pages.HomePage;
import org.selenium.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test
    public void shouldBeAbleToGoToContactPageAndSendForm()  {
        String name = "testUser";
        String email = name + "@email.com";
        String subject = "testSubject";
        String message = "Lorem Ipsum";

        ContactPage contactPage = new HomePage(getDriver())
                .load()
                .getHeader().clickOnPolishButton().clickOnContactLinkFromMenu();
        contactPage
                .fillForm(name, email, subject, message)
                .sendForm();

        Assert.assertEquals(contactPage.getResponse(), TestDataReader.SUCCESSFUL_CONTACT_MESSAGE.getProperty());
    }
}
