package com.example.tests.GroupTests;
import com.example.tests.TestBase;
import org.testng.annotations.Test;

public class NonEmptyGroupCreationTest extends TestBase {

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData();
        group.groupName = "group name";
        group.header = "header 1";
        group.footer = "footer 1";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }


}
