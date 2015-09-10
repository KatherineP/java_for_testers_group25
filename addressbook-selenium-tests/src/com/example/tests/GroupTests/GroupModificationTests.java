package com.example.tests.GroupTests;

import com.example.tests.TestBase;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alex on 04.09.2015.
 */
public class GroupModificationTests extends TestBase {
    @Test (dataProvider = "randomValidGroupsGenerator")
    public void modifySomeGroup(GroupData group){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getGroupHelper().initGroupModification(index);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List <GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        oldList.remove(index);
        oldList.add(group);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
