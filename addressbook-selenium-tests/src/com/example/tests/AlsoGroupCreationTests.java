package com.example.tests;
import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        goToGroupsPage();
        initGroupCreation();
        GroupData group = new GroupData();
        group.groupname = "group name";
        group.header = "header 1";
        group.footer = "footer 1";
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

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
