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
public class GroupRemovalTests extends TestBase {

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().goToGroupsPage();
        //save old state
        List<GroupData> oldList = app.getGroupHelper().getgroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getGroupHelper().deleteGroup(index);
        app.getGroupHelper().returnToGroupPage();

        //save new state
        List <GroupData> newList = app.getGroupHelper().getgroups();
        //compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
