package com.example.tests.ContactTests;

import com.example.tests.ContactTests.ContactData;
import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class EmptyContactCreationTest extends TestBase {

    @Test
    public void EmptyContactCreationTest() throws Exception {
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        ContactData contact = new ContactData("", "", "", "", "", "", "-", "-", "-", "[none]");
        app.getContactHelper().gotoNewContactPage();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);

    }

}
