package com.example.tests.ContactTests;

        import com.example.tests.TestBase;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;
        import static org.testng.Assert.assertEquals;
        import java.util.*;

public class ContactCreationTest extends TestBase {


    @Test (dataProvider = "randomValidContactsGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception {
        app.getNavigationHelper().openMainPage();
        //save old state
      List<ContactData> oldList = app.getContactHelper().getContacts();

        //actions
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
