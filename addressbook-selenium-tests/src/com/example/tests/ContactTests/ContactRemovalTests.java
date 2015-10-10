package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;


public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact() {
        List<ContactData> oldList = app.getContactHelper().getContacts();

            Random rnd = new Random();
            int index = rnd.nextInt(oldList.size() - 1);
            //actions
            app.getContactHelper().removeContact(index);

        List<ContactData> newList = app.getContactHelper().getContacts();
            //compare states
            oldList.remove(index);
            assertEquals(newList, oldList);
        }
    }

