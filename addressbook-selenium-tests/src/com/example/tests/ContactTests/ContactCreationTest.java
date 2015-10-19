package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.example.tests.ContactTests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.ContactTests.ContactDataGenerator.loadContactsFromCsvFile;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ContactCreationTest extends TestBase {


    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
        //return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
        return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
    }




    @Test (dataProvider = "contactsFromFile")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        //save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
        app.getContactHelper().createContact(contact);


        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states
        oldList.add(contact);
        Collections.sort(oldList);
        Collections.sort(newList);
        assertEquals(newList, oldList);

    }




}
