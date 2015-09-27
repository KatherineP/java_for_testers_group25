package com.example.tests.ContactTests;

import com.example.tests.TestBase;
        import static frameWork.ContactHelper.CREATION;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
        import static org.testng.Assert.assertEquals;
        import java.util.*;

public class ContactCreationTest extends TestBase {


    @Test (dataProvider = "randomValidContactsGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().createContact(contact, CREATION);


        //save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.add(contact);

        assertEquals(newList, oldList);
    }




}
