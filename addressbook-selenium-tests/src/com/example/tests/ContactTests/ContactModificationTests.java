package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {
    @Test (dataProvider = "randomValidContactsGenerator")
    public void modifySomeContact(ContactData contact){
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getContactHelper().modifyContact(index, contact);


        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.remove(index);
        oldList.add(contact);
        assertEquals(newList, oldList);
    }
}
