package com.example.tests.GroupTests;

import com.example.tests.TestBase;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

/**
 * Created by Alex on 04.09.2015.
 */
public class GroupModificationTests extends TestBase {
    @Test (dataProvider = "randomValidGroupsGenerator")
    public void modifySomeGroup(GroupData group){
        //save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        //actions
        app.getGroupHelper().modifyGroup(index, group);

        //save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
        //compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
    }
}
