package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactModification(8);
        ContactData contact = new ContactData();
        contact.firstname = "ContactModificationTests";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
