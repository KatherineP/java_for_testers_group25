package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Alex on 25.08.2015.
 */
public class EmptyContactCreationTest extends TestBase{
    @Test
    public void EmptyContactCreationTest() throws Exception {
        openMainPage();
        gotoNewContactPage();
        ContactData contact = new ContactData();
        contact.firstname = "";
        contact.lastname = "";
        contact.address = "";
        contact.mobile = "";
        contact.home = "";
        contact.email = "";
        contact.bday = "-";
        contact.bmonth = "-";
        contact.byear = "-";
        contact.group = "[none]";
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();

    }

}
