package com.example.tests.GroupTests;
import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class EmptyGroupCreationTest extends TestBase {

    @Test
    public void GroupCreationWithInvalidData() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();

        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        //actions
        GroupData group = new GroupData("", "", "");
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List <GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

}
