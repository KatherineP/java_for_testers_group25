package com.example.tests.GroupTests;
import com.example.tests.TestBase;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.*;

public class NonEmptyGroupCreationTest extends  TestBase{

        @Test(dataProvider = "randomValidGroupsGenerator")
        public void GroupCreationWithValidData (GroupData group)throws Exception {
            app.getNavigationHelper().openMainPage();
            app.getNavigationHelper().goToGroupsPage();
            //save old state
            List<GroupData> oldList = app.getGroupHelper().getgroups();
            //actions
            app.getGroupHelper().initGroupCreation();

            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().returnToGroupPage();
            //save new state
            List<GroupData> newList = app.getGroupHelper().getgroups();
            //compare states
            oldList.add(group);
            Collections.sort(oldList);
            assertEquals(newList, oldList);
        }


    }

