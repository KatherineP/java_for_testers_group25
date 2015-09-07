package com.example.tests.GroupTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

/**
 * Created by Alex on 04.09.2015.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.groupName = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
