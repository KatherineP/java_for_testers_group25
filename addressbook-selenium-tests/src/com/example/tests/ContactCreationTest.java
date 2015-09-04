package com.example.tests;

        import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void NonEmptyContactCreationTest() throws Exception {
        app.getNavigationHelper().openMainPage();
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
        //contact.group = "Rob";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

    }




}
