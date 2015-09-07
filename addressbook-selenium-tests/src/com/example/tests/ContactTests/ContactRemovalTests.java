package com.example.tests.ContactTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;


public class ContactRemovalTests extends TestBase {

    @Test
    public void deleteSomeContact(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().deleteGroup(10); //номера начинаются с 2
        app.getContactHelper().returnToHomePage();
    }
}
