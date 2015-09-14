package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {
    @Test
    public void modifySomeContact(){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().initContactModification(2);
        ContactData contact = new ContactData();
        contact.email = "modification@test.test";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContactModification();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.remove(0);
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
