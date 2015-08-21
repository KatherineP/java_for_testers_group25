package com.example.tests;
import org.testng.annotations.Test;

public class NonEmptyGroupCreationTest extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        goToGroupsPage();
        initGroupCreation();
        GroupData group = new GroupData();
        group.groupName = "group name";
        group.header = "header 1";
        group.footer = "footer 1";
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }


}
