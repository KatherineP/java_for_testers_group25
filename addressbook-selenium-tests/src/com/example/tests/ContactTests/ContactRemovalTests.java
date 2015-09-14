package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().deleteGroup(2); //номера начинаются с 2
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.remove(0);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);
    }
}
