package com.example.tests.ContactTests;

import com.example.tests.ContactTests.ContactData;
import com.example.tests.TestBase;
import org.testng.annotations.Test;

public class EmptyContactCreationTest extends TestBase {

    @Test
    public void EmptyContactCreationTest() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().gotoNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "-", "-", "-", "[none]"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

    }

}
