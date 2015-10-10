package com.example.tests.GroupTests;
import com.example.tests.TestBase;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class NonEmptyGroupCreationTest extends  TestBase{

        @Test(dataProvider = "randomValidGroupsGenerator")
        public void GroupCreationWithValidData (GroupData group)throws Exception {
            SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
            //actions
            app.getGroupHelper().createGroup(group);
            SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
            //compare states
            assertThat(newList, equalTo(oldList.withAdded(group)));
        }


    }

