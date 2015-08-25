package com.example.tests;
import org.testng.annotations.Test;

public class EmptyGroupCreationTest extends TestBase{

    @Test
    public void testEmptyGroupCreation() throws Exception {
        openMainPage();
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData("", "", ""));
        submitGroupCreation();
        returnToGroupPage();
    }

}