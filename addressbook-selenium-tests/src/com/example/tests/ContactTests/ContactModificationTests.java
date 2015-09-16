package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {
    @Test (dataProvider = "randomValidContactsGenerator")
    public void modifySomeContact(ContactData contact){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);


        //actions
        app.getContactHelper().initContactModification(index);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().updateContactModification();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
