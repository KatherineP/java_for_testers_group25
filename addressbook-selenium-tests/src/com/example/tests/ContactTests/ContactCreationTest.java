package com.example.tests.ContactTests;

        import com.example.tests.TestBase;
        import org.testng.annotations.Test;
        import static org.testng.Assert.assertEquals;

        import java.util.Collections;
        import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void NonEmptyContactCreationTest() throws Exception {
        app.getNavigationHelper().openMainPage();
        //save old state
       List<ContactData> oldList = app.getContactHelper().getContacts();
        //actions
        app.getContactHelper().gotoNewContactPage();
        ContactData contact = new ContactData();
        contact.firstname = "firstName";
        contact.lastname = "lastName";
        contact.address = "address";
        contact.mobile = "1234567891";
        contact.home = "home";
        contact.email = "test@test.test";
        contact.bday = "23";
        contact.bmonth = "June";
        contact.byear = "1989";
        contact.group = "Rob";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

        //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();
        //compare states

        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

    }




}
